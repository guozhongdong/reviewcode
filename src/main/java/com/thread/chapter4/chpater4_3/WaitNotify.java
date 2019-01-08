package com.thread.chapter4.chpater4_3;

import com.thread.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author gzd
 * @date create in 2019/1/8 16:02
 **/
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Wait(),"waitThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread1 = new Thread(new Notify(),"notifyThread");
        thread1.start();
    }

    static class Wait implements Runnable{

        public void run(){
            //加锁
            synchronized (lock){
                //当条件满足时，继续等待，
                while (flag){

                    try {
                        System.out.println(Thread.currentThread()+"flag is true. wait@"+
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+"flag is false. running@"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{

        public void run(){
            //获取lock锁
            synchronized (lock){
                //获取lock锁，然后用notify唤醒wait的对象，但是不会立即唤醒，会等当前线程执行完毕后，
                //才唤醒
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep " +
                        "" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
