package com.yefeng.nio.buffer.demo1;

import java.nio.ByteBuffer;

import static com.yefeng.nio.buffer.ByteBufferUtil.debugAll;

public class ByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        // 写入一个数值
        byteBuffer.put((byte) 0x61);
        debugAll(byteBuffer);
        byteBuffer.put(new byte[]{0x62, 0x63, 0x64});
        debugAll(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
        debugAll(byteBuffer);
        byteBuffer.compact();
        debugAll(byteBuffer);
        byteBuffer.put(new byte[]{0x65, 0x66});
        debugAll(byteBuffer);
    }
}
