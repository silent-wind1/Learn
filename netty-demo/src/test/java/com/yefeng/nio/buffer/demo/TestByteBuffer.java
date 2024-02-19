package com.yefeng.nio.buffer.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBuffer {
    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileInputStream("F:\\Learn\\netty-demo\\src\\test\\java\\com\\yefeng\\nio\\buffer\\demo\\data.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(20);
            while (true) {
                int len = fileChannel.read(buffer);
                if (len == -1) {
                    break;
                }
                buffer.flip();
                // buffer.hasRemaining() -> for i < buffer.length()
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();
                // 关闭fileChannel
                fileChannel.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
