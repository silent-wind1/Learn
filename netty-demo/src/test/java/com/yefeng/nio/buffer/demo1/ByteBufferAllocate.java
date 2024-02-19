package com.yefeng.nio.buffer.demo1;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class ByteBufferAllocate {
    public static void main(String[] args) {
        // class java.nio.HeapByteBuffer - java堆内推，读写效率较低，受GC的影响
        // class java.nio.DirectByteBuffer - 直接内存，读写效率高（少一次拷贝），不会受GC影响，分配效率低
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
    }
}
