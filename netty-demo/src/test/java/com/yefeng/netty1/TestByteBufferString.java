package com.yefeng.netty1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.yefeng.netty1.ByteBufferUtil.debugAll;

public class TestByteBufferString {
    public static void main(String[] args) {
        byte[] bytes = "yefeng".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(bytes);
        debugAll(buffer);

        // 2.Charset，切换到读模式
        ByteBuffer buf3 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buf3);

        // 3.wrap() 方法，切换到读模式
        ByteBuffer buf4 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buf4);
        System.out.println((char) buf4.get()); // h

        // ByteBuffer --> String
        String buf2Str = StandardCharsets.UTF_8.decode(buf3).toString();
        System.out.println(buf2Str);
    }
}
