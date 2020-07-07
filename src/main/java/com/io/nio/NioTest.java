package com.io.nio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/7
 */
public class NioTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("localhost", 8092);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        byte[] bytes = "fdfd123123123".getBytes();
        System.out.println("send fdfd");
        out.write(bytes);
        out.flush();

        Thread.sleep(5*1000);

        System.out.println("send loll");
        out.write("loull11231".getBytes());
        out.flush();


        socket.close();
        out.close();

        Thread.sleep(1*1000);

        System.out.println("client socket close");


    }
}
