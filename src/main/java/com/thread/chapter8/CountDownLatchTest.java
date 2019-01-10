package com.thread.chapter8;

import java.util.concurrent.CountDownLatch;

/**
 * @author gzd
 * @date create in 2019/1/10 18:37
 **/
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
          System.out.println(1);
          c.countDown();
          System.out.println(2);
          c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}
