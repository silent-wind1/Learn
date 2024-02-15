package com.yefeng.netty1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBuffer {
    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileInputStream("data.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(20);
            while (true) {
                int len = fileChannel.read(buffer);
                if (len == -1) {
                    break;
                }
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
