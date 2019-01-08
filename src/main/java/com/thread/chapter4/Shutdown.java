package com.thread.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author gzd
 * @date create in 2019/1/6 23:23
 * 终止线程
 * 1、中断操作
 * 2、逻辑位
 **/
public class Shutdown {


    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one,"CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();

    }

    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = "+i);
        }

        public void cancel(){
            on = false;
        }
    }
}
