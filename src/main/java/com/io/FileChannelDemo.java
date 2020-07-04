package com.io;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gzd
 * @date 2019/10/27 下午5:24
 */
public class FileChannelDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(24);
        /*buffer.clear();
        buffer.put("hello".getBytes());
        System.out.println("before compact="+buffer);
        System.out.println(new String(buffer.array()));
        buffer.flip();
        System.out.println("after flip:"+buffer);
        // 从 position开始读取字节，
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        // 读取三个之后，查看position 和limit的位置
        System.out.println("three after flip:"+buffer);
        System.out.println(new String(buffer.array()));
        // 清除已读取的数据，保留未读取的数据
        buffer.compact();
        System.out.println("compact 之后："+buffer);
        System.out.println(new String(buffer.array()));*/
        System.out.println("test get..............");
        buffer = ByteBuffer.allocate(32);
        buffer.put((byte)'a').put((byte)'b').put((byte)'c').put((byte)'d').put((byte)'e').put((byte)'f');
        System.out.println(new String(buffer.array()));
        System.out.println("before flip:"+buffer);
        buffer.flip();
        System.out.println("before get:"+buffer);
        System.out.println((char)buffer.get());
        System.out.println("after get:"+buffer);
        System.out.println((char)buffer.get(2));
        // get(index) 不影响position 的位置
        System.out.println("after get(index):"+buffer);
        byte[] dst = new byte[10];
        buffer.get(dst,0,2);
        System.out.println("after get(index) dst 0 ,2:"+buffer);
        System.out.println("\t dst:"+new String(dst));
        System.out.println("buffer now is :"+buffer);
    }



}
