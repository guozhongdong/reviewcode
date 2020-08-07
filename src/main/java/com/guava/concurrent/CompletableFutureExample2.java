package com.guava.concurrent;

import lombok.SneakyThrows;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.*;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/7
 * 测试一下异步的能力
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        long start = System.currentTimeMillis();
        CompletableFuture future =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1";
        } ,executor);

        CompletableFuture future2 =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2";
        } ,executor);

        System.out.println(future.get());
        System.out.println(future2.get());
        System.out.println((System.currentTimeMillis()-start)+":ms");
    }
}
