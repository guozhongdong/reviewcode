package com.guava.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import lombok.SneakyThrows;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/6
 * Future的使用
 */
public class FutureDemo {

    public static void main(String[] args) {

        async2();
    }
    public static void commint() throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        // 创建一个Listenable包装的线程池工具类  功能类似ExecutorService
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        Map<String,Object> monitorBandMap = new HashMap<>();
        Map<String,Object> countMap = new HashMap<>(4);
        monitorBandMap.put("a",6);
        monitorBandMap.put("b",7);
        monitorBandMap.put("c",8);
        monitorBandMap.put("d",9);
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (Map.Entry<String,Object> entry : monitorBandMap.entrySet()) {

            ListenableFuture<Object> explosion = service.submit(new Callable<Object>() {
                @Override
                public Object call() throws InterruptedException {
                    try {
                        Thread.sleep(500);
                        System.out.println("call");
                        return integer.incrementAndGet()+Integer.valueOf((Integer) entry.getValue());
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });

            Futures.addCallback(explosion, new FutureCallback<Object>() {
                // we want this handler to run immediately after we push the big red button!
                @Override
                public void onSuccess(Object explosion) {
                    countMap.put(entry.getKey(),explosion);
                }
                @Override
                public void onFailure(Throwable thrown) {
                    System.out.println("error");
                }
            },MoreExecutors.directExecutor());

        }
        countDownLatch.await();
        System.out.println(countMap);
        System.out.println((System.currentTimeMillis() - start)+" ms");
    }
    public static void async(){
        ListenableFutureTask<String> task1 = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "task1 执行了";
            }
        });
        new Thread(task1).start();
        task1.addListener(new Runnable() {
            @Override
            public void run() {
                System.out.println("task1 回调了");
                ListenableFutureTask<String> task2 = ListenableFutureTask.create(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return "task2执行了，";
                    }
                });
                task2.addListener(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("task2 回调了，，");
                    }
                }, MoreExecutors.directExecutor());
                new Thread(task2).start();
            }
        }, MoreExecutors.directExecutor());
    }

    public static void async2(){
        long start = System.currentTimeMillis();
        ListenableFutureTask<String> task1 = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {

                Thread.sleep(500);
                return "task1 执行了";
            }
        });
        new Thread(task1).start();
        //当task1执行完毕会回调执行Function的apply方法，如果有task1有异常抛出，则task2也抛出相同异常，不执行apply
        ListenableFuture<String> task2 = Futures.transform(task1, new Function<String, String>() {
            @SneakyThrows
            @Nullable
            @Override
            public String apply(@Nullable String s) {
                System.out.println("任务1"+s);
                Thread.sleep(500);
                return "task2 执行了";
            }
        },MoreExecutors.directExecutor());


        Futures.addCallback(task2, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("都执行完了==="+s);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        },MoreExecutors.directExecutor());
        System.out.println("时间："+(System.currentTimeMillis()-start));
    }
}
