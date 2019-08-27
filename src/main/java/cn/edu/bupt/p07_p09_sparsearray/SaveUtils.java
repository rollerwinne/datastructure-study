package cn.edu.bupt.p07_p09_sparsearray;

import java.io.*;

/**
 * 用序列化完成保存的小练习
 * 其实可以用泛型扩展
 */
public class SaveUtils {
    private static String filename = "map.data";

    /**
     * @param arr 稀疏数组
     * @return 返回保存的文件
     */
    public static File saveArray(SparseArray arr) {
        String path = SaveUtils.class.getResource("").getFile();
        File file = new File(path, filename);
        try {
            if (!file.exists())
                file.createNewFile();
            //System.out.println(file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    /**
     * 从特定路径中读取文件
     * @return 返回转换后的稀疏数组
     */
    public static SparseArray readArray(){
        String path = SaveUtils.class.getResource("").getFile();
        File file = new File(path, filename);
        return readArray(file);
    }

    public static SparseArray readArray(File file){
        SparseArray sa = null;
        try {
            if (!file.exists())
                throw new RuntimeException("文件不存在");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sa = (SparseArray) ois.readObject();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return sa;
    }
}
