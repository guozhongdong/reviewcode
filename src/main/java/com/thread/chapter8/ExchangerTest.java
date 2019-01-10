package com.thread.chapter8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gzd
 * @date create in 2019/1/10 21:59
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadpool = Executors.newFixedThreadPool(2);

    public static void main(String[] args){
        threadpool.execute(() ->{
            String A = "银行流水B";
            try {
                exgr.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadpool.execute(() ->{
            String B = "银行流水B";
            try {
                String A = exgr.exchange("B");
                System.out.println("A和B的数据是否一致："+A.equals(B)+",A录入的是："+A+",B录入的是："+B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadpool.shutdown();
    }

}
