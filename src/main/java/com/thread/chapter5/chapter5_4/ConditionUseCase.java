package com.thread.chapter5.chapter5_4;

import com.thread.SleepUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gzd
 * @date create in 2019/1/10 16:12
 **/
public class ConditionUseCase  {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void conditionWait() throws InterruptedException{
        lock.lock();
        try {
            condition.await();
            System.out.println("是否一致等待！！");
        }finally {
            lock.unlock();
        }
    }


    public void conditionSignal(){
        lock.lock();
        try {
            condition.signal();
            System.out.println("唤醒！！！！！！");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)  {
        final ConditionUseCase conditionUseCase = new ConditionUseCase();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionUseCase.conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(1);
                    conditionUseCase.conditionSignal();

            }
        });
        t1.start();
    }
}
