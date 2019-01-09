package com.thread.chapter4.chapter4_4.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gzd
 * @date create in 2019/1/9 9:59
 **/
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        final int threadNum = 10;
         final CountDownLatch count = new CountDownLatch(threadNum);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("run"+Thread.currentThread().getName());
                    count.countDown();
                }
            });
        }
        count.await();
        System.out.println("countlatch 执行完毕！");
        executorService.shutdown();

    }
}
