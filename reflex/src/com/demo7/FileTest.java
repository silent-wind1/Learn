package com.demo7;

import org.junit.Test;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src/com/demo7/FileTest.java");
        System.out.println(file.getAbsolutePath());
        FileReader fileReader = new FileReader(file);
        int data = fileReader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fileReader.read();
        }
        fileReader.close();
    }

    @Test
    public void testFileInputOutStream() {

    }

    /**
     * 使用字符流进行读取文件
     */
    @Test
    public void testFileReader() {
        try {
            //  获取文件路径
            FileReader fileReader = new FileReader("src/com/demo7/FileTest.java");
            // 设置一个变量接受读取
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 使用字符流进行存储文件
     */
    @Test
    public void testFileWriter() {
        try {
            // 如果路径中没有改文件则会创建新一个新文件
            FileWriter fileWriter = new FileWriter("src/helloword.txt");
            fileWriter.write("故事的小黄花，从飘落就啦啦啦");
            System.out.println("输出入成功");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("输入失败");
        }
    }

    /**
     * 使用字节流读取文件
     */
    @Test
    public void testInputStream() {
        try {
            FileInputStream inputStream = new FileInputStream("src/com/demo7/FileTest.java");
            // 读取数据
            byte[] bytes = new byte[1024];
            int data;   // 记录每次读取的字节个数
            while ((data= inputStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, data);
                System.out.print(str);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFileOutStream() {
        try {
            FileOutputStream outputStream = new FileOutputStream("src/helloword1.txt");
            FileInputStream inputStream = new FileInputStream("src/helloword.txt");
            byte[] bytes = new byte[1024];
            int data;
            while ((data = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, data);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
