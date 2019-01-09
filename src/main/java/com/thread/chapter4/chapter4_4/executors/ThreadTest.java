package com.thread.chapter4.chapter4_4.executors;

/**
 * @author gzd
 * @date create in 2019/1/8 22:00
 **/
public class ThreadTest {

    public static void main(String[] args){
        RunJob thread = new RunJob();

        DefaultThreadPool<RunJob> defaultThreadPool= new DefaultThreadPool<RunJob>();
        defaultThreadPool.execute(thread);

        String x = "7";
        int y =1;
        int z = 2 ;
        System.out.println(x+y+z);
    }

    static class RunJob implements Runnable{

        public void run() {
            System.out.println("我是一个任务！！！");
        }
    }
}
