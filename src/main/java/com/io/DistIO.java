package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gzd
 * @create 2018-11-01 15:07
 * @desc 磁盘IO
 **/
public class DistIO {
    public static void main(String[] args){

    }
    /**
     * 使用NIO 复制文件
     * */
    public static void fastCopy(String src,String dist) throws IOException {
        //获取文件的输入流
        FileInputStream file = new FileInputStream(src);
        //获取 输入流的文件通道
        FileChannel fileChannel = file.getChannel();

        FileOutputStream out = new FileOutputStream(dist);

        FileChannel outChannel = out.getChannel();
        //为缓冲区分配1024个字节，
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        while (true){
            // 将输入流读取到缓冲区
            int r = fileChannel.read(byteBuffer);
            //读到文件尾则是-1
            if (r == -1){
                break;
            }

            // 执行flip,切换缓冲区的读取
            byteBuffer.flip();

            outChannel.write(byteBuffer);

            byteBuffer.clear();
        }
    }
}
