package com.thread.interrupt;

import java.sql.SQLOutput;

/**
 * @author gzd
 * @date 2019/6/10 下午6:36
 */
public class InterruptTest {

    private static  class MyThread2 extends  Thread{

        @Override
        public void run(){
            while (true){
                System.out.println(interrupted());
                if (!interrupted()){
                    System.out.println("111");
                }else{
                    System.out.println("中断了，");
                }

            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread mythread2 = new MyThread2();
        mythread2.start();
        Thread.sleep(10);
        mythread2.interrupt();
    }

}
