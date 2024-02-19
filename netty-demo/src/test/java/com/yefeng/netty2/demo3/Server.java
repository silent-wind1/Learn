package com.yefeng.netty2.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static com.yefeng.nio.buffer.ByteBufferUtil.debugAll;

/**
 * 处理read事件
 */
public class Server {
    private static final Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(16);
        // 获得服务器通道
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            // 为服务器通道绑定端口
            server.bind(new InetSocketAddress(8080));

            // 创建选择器
            Selector selector = Selector.open();
            server.configureBlocking(false);
            // 将通道注册到选择器中，并设置感兴趣事件
            server.register(selector, SelectionKey.OP_ACCEPT);
            log.debug("register key = {}", server);
            // 循环接收连接
            while (true) {
                // 若没有事件就绪，线程会被阻塞，反之不会被阻塞。从而避免了CPU空转
                // 返回值为就绪的事件个数
                int select = selector.select();
                System.out.println("selector ready counts : " + select);

                // 获取所有事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    log.debug("next = {}", next);
                    if (next.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                        log.debug("{}", channel);
                        // 获取连接并处理，而且是必须处理，否则需要取消
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        SelectionKey register = socketChannel.register(selector, 0, null);
                        register.interestOps(SelectionKey.OP_READ);
                    } else if (next.isReadable()) {
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
                        channel.read(byteBuffer);
                        buffer.flip();
                        debugAll(byteBuffer);
                        buffer.clear();
                        // 处理完毕后移除
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}