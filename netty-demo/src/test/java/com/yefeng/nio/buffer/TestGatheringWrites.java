package com.yefeng.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestGatheringWrites {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("words2.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4);
            ByteBuffer buffer1 = ByteBuffer.allocate(4);
            channel.position(0);
            buffer.put(new byte[] {'y','e','n','g'});
            buffer1.put(new byte[]{'y','l','s','l'});
            // 切换读模式
            buffer.flip();
            buffer1.flip();
            ByteBufferUtil.debugAll(buffer);
            ByteBufferUtil.debugAll(buffer1);
            // 写入到words2.txt文件中
            channel.write(new ByteBuffer[] {buffer, buffer1});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 分散读取
        try {
            FileChannel channel = new RandomAccessFile("words2.txt", "r").getChannel();
            ByteBuffer buf1 = ByteBuffer.allocate(3);
            ByteBuffer buf2 = ByteBuffer.allocate(3);
            ByteBuffer buf3 = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{buf1, buf2, buf3});
            buf1.flip();
            buf2.flip();
            buf3.flip();
            ByteBufferUtil.debugAll(buf1);
            ByteBufferUtil.debugAll(buf2);
            ByteBufferUtil.debugAll(buf3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
