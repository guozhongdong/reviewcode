package com.thread.chapter8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author gzd
 * @date create in 2019/1/10 18:54
 **/
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3);
    public static void main(String[] args){
        /*new Thread(() ->{
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);*/
    }

}

