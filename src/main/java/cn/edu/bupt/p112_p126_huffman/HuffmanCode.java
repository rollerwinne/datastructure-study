package cn.edu.bupt.p112_p126_huffman;

import java.util.*;

public class HuffmanCode {
    //解码需要知道的信息：位长度和编码表
    private Map<Byte, String> huffmanMap;
    private int bitLength;

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        System.out.println("原字符串:" + content);
        HuffmanCode huffmanCode = new HuffmanCode();
        System.out.println("原字符串字节数:" + content.getBytes().length + " ==> " + Arrays.toString(content.getBytes()));
        byte[] encode = huffmanCode.encode(content.getBytes());
        System.out.println("编码字符串字节数:" + encode.length + " ==> " + Arrays.toString(encode));
        byte[] decode = huffmanCode.decode(encode);
        System.out.println("解码字符串字节数:" + decode.length + " ==> " + Arrays.toString(decode));
        String decodeStr = new String(decode);
        System.out.println("解码字符串:" + decodeStr);
    }

    /**
     * 暴露的非静态public方法:哈夫曼解码
     * 韩老师的方法有两个问题  1.最后一个字节为8位的负数时(解码后会多出24位1)
     * 2.最后一个字节为小于8位的正数，且首位为0时(解码后会丢掉若干0)
     * 有问题的用例case: str="i like like like java do you like a javab"(抛异常)
     * 已修复:编码时传入原始字节长度
     *
     * @param bytes
     * @return
     */
    public byte[] decode(byte[] bytes) {
        if (this.huffmanMap == null)
            throw new RuntimeException("请先编码,再执行解码");
        StringBuilder decodeStr = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            decodeStr.append(byteToBinaryString(bytes[i], (i == bytes.length - 1) ? this.bitLength % 8 : 8));
        }
        //翻转huffmanCode
        Map<String, Byte> huffmanDecode = new HashMap<>();
        for (Map.Entry<Byte, String> entry : this.huffmanMap.entrySet()) {
            huffmanDecode.put(entry.getValue(), entry.getKey());
        }
        //解码结果放入list
        List<Byte> decodeList = new ArrayList<>();
        int left = 0, right = 1;
        while (left < decodeStr.length()) {
            String temp = decodeStr.substring(left, right);
            Byte b = huffmanDecode.get(temp);
            if (b != null) {
                decodeList.add(b);
                left = right;
                right = left + 1;
            } else {
                right++;
            }
        }
        // return decodeList.toArray(new Byte[0]); //若返回Byte[]可这么写
        byte[] decodeBytes = new byte[decodeList.size()];
        for (int i = 0; i < decodeList.size(); i++) {
            decodeBytes[i] = decodeList.get(i);
        }
        return decodeBytes;
    }

    /**
     * 单字节转二进制字符串
     *
     * @param b
     * @param length
     * @return
     */
    private static String byteToBinaryString(byte b, int length) {
        if (length > 8 || length < 0)
            throw new RuntimeException("字节长度有误");
        String str = Integer.toBinaryString(b | 256);
        return str.substring(str.length() - length);
    }

    /**
     * 暴露的非静态public方法:哈夫曼编码
     *
     * @param bytes
     * @return
     */
    public byte[] encode(byte[] bytes) {
        List<Node> list = getNodes(bytes);//统计频度
        Node root = getHuffmanTree(list);//生成HuffmanTree
        Map<Byte, String> huffmanCode = getHuffmanCode(root);//生成编码表
        this.huffmanMap = huffmanCode;
        return zip(bytes, huffmanCode);//返回压缩数组
    }

    /**
     * 根据Huffman编码表压缩数组
     *
     * @param bytes
     * @param huffmanCode
     * @return
     */
    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder code = new StringBuilder();
        for (byte b : bytes) {
            code.append(huffmanCode.get(b));
        }
        this.bitLength = code.length();
        int length = (code.length() + 7) / 8;
        byte[] zipCode = new byte[length];
        for (int i = 0; i < length; i++) {
            zipCode[i] = (i == length - 1)
                    ? (byte) Integer.parseInt(code.substring(i * 8), 2)
                    : (byte) Integer.parseInt(code.substring(i * 8, (i + 1) * 8), 2);
        }
        return zipCode;
    }

    /**
     * 根据HuffmanTree创建编码表
     *
     * @param node
     * @return
     */
    private static Map<Byte, String> getHuffmanCode(Node node) {
        Map<Byte, String> huffmanCode = new HashMap<>();
        HuffmanCode.getHuffmanCode(node, "", huffmanCode);
        return huffmanCode;
    }

    /**
     * 递归创建HuffmanCode
     * 在这里，韩老师传入的StringBuilder多余了
     *
     * @param node
     * @param code
     * @param huffmanCode
     */
    private static void getHuffmanCode(Node node, String code, Map<Byte, String> huffmanCode) {
        if (node == null) {
            return;
        }
        if (node.data == null) {
            getHuffmanCode(node.left, code + "0", huffmanCode);
            getHuffmanCode(node.right, code + "1", huffmanCode);
        } else {
            huffmanCode.put(node.data, code);
        }
    }

    /**
     * 根据节点频度创建HuffmanTree
     *
     * @param list
     * @return
     */
    private static Node getHuffmanTree(List<Node> list) {
        if (list == null || list.size() == 0)
            return null;
        Node leftNode;
        Node rightNode;
        Node temp;
        while (list.size() > 1) {
            Collections.sort(list);
            leftNode = list.get(0);
            rightNode = list.get(1);
            temp = new Node(null, leftNode.weight + rightNode.weight);
            temp.left = leftNode;
            temp.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(temp);
        }
        return list.get(0);
    }

    /**
     * 统计节点频度
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte data : bytes) {
            Integer count = map.get(data);
            if (count == null) {
                map.put(data, 1);
            } else {
                map.put(data, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    private static class Node implements Comparable<Node> {
        Byte data;
        int weight;
        Node left;
        Node right;

        Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }

    public HuffmanCode() {
    }

    public HuffmanCode(Map<Byte, String> huffmanMap, int bitLength) {
        this.huffmanMap = huffmanMap;
        this.bitLength = bitLength;
    }

    public Map<Byte, String> getHuffmanMap() {
        return huffmanMap;
    }

    public void setHuffmanMap(Map<Byte, String> huffmanMap) {
        this.huffmanMap = huffmanMap;
    }

    public int getBitLength() {
        return bitLength;
    }

    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }
}
