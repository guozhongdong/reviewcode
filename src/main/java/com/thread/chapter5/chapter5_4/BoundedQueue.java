package com.thread.chapter5.chapter5_4;

import com.thread.SleepUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gzd
 * @date create in 2019/1/10 16:26
 **/
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex,removeIndex,count;
            private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    public BoundedQueue(int size){
        items = new Object[size];
    }
    // 添加一个元素，如果数组满，则添加线程进入到等待状态，直到有“空位”
    public void add (T t) throws InterruptedException {
        try {
            lock.lock();
            while (count == items.length){
                System.out.println("已经满了，需要等待！");
                notFull.await();
            }

            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;
            System.out.println("数组中有元素了，通知获取线程开始获取吧！！！！");
            notEmpty.signal();
        }finally {
            lock.unlock();
        }

    }

    //删除一个元素，如果数组为空，则删除线程进入到等待状态，直到有新添加元素


    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                System.out.println("现在是空的，我要等待！！！");
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length){
                removeIndex = 0;
            }
            --count;
            System.out.println("现在队列不满，添加线程可以添加元素了，！！！");
            notFull.signal();
            return (T)x;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final BoundedQueue<Integer> boundedQueue = new BoundedQueue(10);
        Thread t = new Thread(() -> {

                for (int i = 0; i < 12 ; i++) {
                    SleepUtils.second(1);
                    try {
                        boundedQueue.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        });
        t.start();
        Thread t1 = new Thread(() -> {

                try {
                    for (;;){
                        boundedQueue.remove();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        });
        t1.start();

    }

}
