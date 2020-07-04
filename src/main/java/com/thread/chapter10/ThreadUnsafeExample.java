package com.thread.chapter10;

import sun.applet.Main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gzd
 * @date 2019/6/11 下午2:18
 * 线程不安全示例
 */
public class ThreadUnsafeExample {

    private   int cnt = 0 ;

    public synchronized  void add(){
        cnt ++;
    }
    public int get(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize  =1000;
        ThreadUnsafeExample threadUnsafeExample = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                threadUnsafeExample.add();
                countDownLatch.countDown();
            });
        }
        System.out.println("等待所有线程执行完毕！");
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(threadUnsafeExample.get());
    }
}
