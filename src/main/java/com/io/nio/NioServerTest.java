package com.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/7
 */
@Slf4j
public class NioServerTest {

    public static void main(String[] args) throws IOException {

        //打开一个selector,用户轮询用户的事件
        Selector selector = Selector.open();
        // 建立一个监听连接的通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置监听的 地址
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",8092));
        // 设置为非阻塞状态
        serverSocketChannel.configureBlocking(false);
        // 注册到selector上,监听的是链接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 死循环轮询
        while (true){
            // 一直等待channel 事件
            selector.select();
            //获取事件的key值，可能会有很多个事件，后面进行匹配即可
            Set<SelectionKey> set = selector.selectedKeys();
            // 这块为啥不用，foreach遍历呢，？？？？
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                // 如果是链接事件，则下面要创建一个连接的channel，根据上面的监听channel来创建
                if (key.isAcceptable()){
                    log.info("获取客户端的链接！！！！");
                    //获取客户端连接的channel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //设置非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 监听客户端的读事件,并注册到轮询器上，所以下面直接可监听到这个读事件，
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                //监听读操作
                if (key.isReadable()){
                    // 获取读的channel,为啥从key从获取???
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    ByteBuffer byteBuffer = (ByteBuffer)key.attachment();
                    int byteRead = 0;
                    if ((byteRead = socketChannel.read(byteBuffer)) > 0){
                        //切换模式，将读模式切换成写模式
                        byteBuffer.flip();
                        byte[] data = byteBuffer.array();
                        String msg = new String(data).trim();
                        System.out.println("服务端读取的数据为：" + msg);
                    }
                }
                // Selector不会自己从已selectedKeys中移除SelectionKey实例
                // 必须在处理完通道时自己移除 下次该channel变成就绪时，Selector会再次将其放入selectedKeys中
                iterator.remove();
            }


        }

    }


}
