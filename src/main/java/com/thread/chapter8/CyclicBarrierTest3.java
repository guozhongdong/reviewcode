package com.thread.chapter8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author gzd
 * @date create in 2019/1/10 21:45
 **/
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);
    public static void main(String[] args){
        Thread thread = new Thread(() -> {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }

}
