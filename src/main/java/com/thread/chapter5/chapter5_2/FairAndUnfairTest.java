package com.thread.chapter5.chapter5_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gzd
 * @date create in 2019/1/9 22:37
 **/
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    public void fair(){
        //testLock()
    }

    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run(){

        }
    }
    private void testLock(Lock lock){
        for (int i = 0; i < 5 ; i++) {
            Job job = new Job(lock);
            System.out.println("lock by"+Thread.currentThread().getId()+""+"waiting by");
            job.start();
        }
    }
    public static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair){
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public static void main(String[] args){
        new FairAndUnfairTest().testLock(fairLock);
        new FairAndUnfairTest().testLock(unfairLock);
    }
}
