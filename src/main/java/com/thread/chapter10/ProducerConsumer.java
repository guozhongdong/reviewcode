package com.thread.chapter10;

import sun.applet.Main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author gzd
 * @date 2019/6/11 下午2:08
 *
 * 使用BlockingQueue 实现生产者消费者
 */
public class ProducerConsumer {

    private static BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

    static class Producer extends Thread{
        @Override
        public void run(){
            try {
                blockingQueue.put("producer...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce done");
        }
    }

    static class Consumer extends Thread{
        @Override
        public void run(){
            try {
                String product = String.valueOf(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume ...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }


        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }

}
