package com.thread.chapter8;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author gzd
 * @date create in 2019/1/10 19:19
 **/
public class BankWaterService implements Runnable {
    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     * */
    private CyclicBarrier c = new CyclicBarrier(4,this);
    /**
    * 创建4个线程
    * */
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银流数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    //银流计算完成，插入一个屏障
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args){
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
