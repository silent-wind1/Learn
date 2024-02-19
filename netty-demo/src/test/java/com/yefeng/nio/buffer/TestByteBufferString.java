package com.yefeng.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestByteBufferString {
    public static void main(String[] args) {
        byte[] bytes = "yefeng".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(bytes);
        ByteBufferUtil.debugAll(buffer);

        // 2.Charset，切换到读模式
        ByteBuffer buf3 = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtil.debugAll(buf3);

        // 3.wrap() 方法，切换到读模式
        ByteBuffer buf4 = ByteBuffer.wrap("hello".getBytes());
        ByteBufferUtil.debugAll(buf4);
        System.out.println((char) buf4.get()); // h

        // ByteBuffer --> String
        String buf2Str = StandardCharsets.UTF_8.decode(buf3).toString();
        System.out.println(buf2Str);
    }
}
