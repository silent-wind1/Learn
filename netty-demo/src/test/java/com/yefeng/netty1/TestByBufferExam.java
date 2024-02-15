package com.yefeng.netty1;

import java.nio.ByteBuffer;

import static com.yefeng.netty1.ByteBufferUtil.debugAll;

public class TestByBufferExam {
    public static void main(String[] args) {
        // 黏包、半包
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello, world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    private static void split(ByteBuffer source){
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if(source.get(i) == '\n') {
                int len = i + 1 - source.position();
                ByteBuffer buffer = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    buffer.put(source.get());
                }
                debugAll(buffer);
            }
        }
        source.compact();
    }
}
