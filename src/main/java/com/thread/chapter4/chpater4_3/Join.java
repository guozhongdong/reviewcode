package com.thread.chapter4.chpater4_3;

import com.thread.SleepUtils;

/**
 * @author gzd
 * @date create in 2019/1/8 17:11
 **/
public class Join {

    public static void main(String[] args){
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous),String.valueOf(i));
            thread.start();
            previous = thread;

        }
        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }

    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
