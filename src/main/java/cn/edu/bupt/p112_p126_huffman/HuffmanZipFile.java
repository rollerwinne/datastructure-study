package cn.edu.bupt.p112_p126_huffman;

import java.io.*;
import java.net.URL;
import java.util.Map;

public class HuffmanZipFile {
    private static final String keySuffix = ".key";//压缩编码保存的后缀
    private static final int sizeLimit = 1024 * 1024 * 1024;//文件大小限制:1GB

    public static void main(String[] args) {
        URL url = HuffmanZipFile.class.getClassLoader().getResource("");
        String path = url.getPath();
        // File srcFile = new File(path, "bupt_logo.jpg");
        // File encodeFile = new File(path, "bupt_logo.encode.jpg");
        // File decodeFile = new File(path, "bupt_logo.decode.jpg");
        // File srcFile = new File(path, "passage.txt");
        // File encodeFile = new File(path, "passage.encode");
        // File decodeFile = new File(path, "passage.decode.txt");
        File srcFile = new File(path, "风景画.bmp");
        File encodeFile = new File(path, "风景画.encode.bmp");
        File decodeFile = new File(path, "风景画.decode.bmp");

        System.out.println(srcFile.getAbsolutePath());
        System.out.println("原文件大小: " + srcFile.length() + " Bytes");
        zipFile(srcFile, encodeFile);
        System.out.println(encodeFile.getAbsolutePath());
        System.out.println("压缩文件大小: " + encodeFile.length() + " Bytes");
        unzipFile(encodeFile, decodeFile);
    }

    /**
     * 哈夫曼解压
     * 需要加密文件与密钥文件
     *
     * @param zipFile
     * @param dstFile
     */
    public static void unzipFile(File zipFile, File dstFile) {
        if (!zipFile.exists())
            throw new RuntimeException("File " + zipFile + "not exists.");
        File keyFile = getKeyFile(zipFile);
        if (!keyFile.exists())
            throw new RuntimeException("File " + keyFile + "not exists.");
        try (FileInputStream fis1 = new FileInputStream(zipFile);
             FileInputStream fis2 = new FileInputStream(keyFile);
             ObjectInputStream ois = new ObjectInputStream(fis2);
             FileOutputStream fos = new FileOutputStream(dstFile)) {

            Map<Byte, String> huffmanMap = (Map<Byte, String>) ois.readObject();
            int length = ois.readInt();
            HuffmanCode decoder = new HuffmanCode(huffmanMap, length);

            int size = fis1.available();
            byte[] bytes = new byte[size];
            fis1.read(bytes);
            byte[] decodeBytes = decoder.decode(bytes);
            fos.write(decodeBytes);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 哈夫曼压缩
     * 为了对比压缩效果，编码文件与长度信息存到了另一个密钥文件
     *
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(File srcFile, File dstFile) {
        if (!srcFile.exists())
            throw new RuntimeException("File " + srcFile + "not exists.");
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(dstFile);
             FileOutputStream fos2 = new FileOutputStream(getKeyFile(dstFile));
             ObjectOutputStream oos = new ObjectOutputStream(fos2)) {

            int size = fis.available();
            if (size > sizeLimit)
                throw new RuntimeException("too large file:" + size + "Bytes");
            byte[] bytes = new byte[size];
            fis.read(bytes);

            HuffmanCode encoder = new HuffmanCode();
            byte[] encodeBytes = encoder.encode(bytes);
            fos.write(encodeBytes);
            oos.writeObject(encoder.getHuffmanMap());
            oos.writeInt(encoder.getBitLength());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File getKeyFile(File file) {
        return new File(file.getPath() + keySuffix);
    }
}
