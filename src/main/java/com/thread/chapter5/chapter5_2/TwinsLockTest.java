package com.thread.chapter5.chapter5_2;

import com.thread.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * @author gzd
 * @date create in 2019/1/9 22:23
 **/
public class TwinsLockTest {

    public static void main(String[] args){
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run(){
                while (true){
                    lock.lock();
                    try{
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
