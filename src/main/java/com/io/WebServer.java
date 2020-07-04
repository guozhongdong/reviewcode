package com.io;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author gzd
 * @date 2019/10/29 上午11:29
 */
public class WebServer {
    public static void main(String[] args) throws Exception{

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
       socketChannel.socket().bind(new InetSocketAddress("127.0.0.1",7654));
        // L连接到远程服务器
        SocketChannel socketCha = socketChannel.accept();
        // 创建缓冲区读取客户端数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketCha.read(byteBuffer);
        StringBuilder sb = new StringBuilder();
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            sb.append((char)byteBuffer.get());
        }
        System.out.println("从客户端接受数据："+sb.toString());
        socketChannel.close();
        socketCha.close();

    }
}
