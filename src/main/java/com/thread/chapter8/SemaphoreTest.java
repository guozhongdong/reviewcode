package com.thread.chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author gzd
 * @date create in 2019/1/10 21:51
 **/
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadpool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args){
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadpool.execute(() ->{
                try {
                    s.acquire();
                    System.out.println("save data" +s.availablePermits()+" ");
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadpool.shutdown();
    }
}

