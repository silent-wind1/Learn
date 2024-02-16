package netty2;



import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.yefeng.netty1.ByteBufferUtil.debugRead;

@Slf4j
public class Server {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        // create server
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // binding port
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // connect collect
        List<SocketChannel> arrayList = new ArrayList();
        while (true) {
            // 没有连接时，会阻塞线程
            SocketChannel accept = serverSocketChannel.accept();
            // 非阻塞模式
            serverSocketChannel.configureBlocking(false);
            arrayList.add(accept);
            for (SocketChannel channel : arrayList) {
                log.debug("before read ... {}", channel);
                // 当通道中没有数据可读时，会阻塞线程
                channel.read(buffer);
                buffer.flip();
                debugRead(buffer);
                buffer.clear();
                log.debug("after read ... {}", channel);
            }
        }
    }
}
