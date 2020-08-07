package com.guava.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/7
 * CompletableFuture 实现 Futrue,获取回调
 * 对比 ListenableFuture
 */
public class CompletableFutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        long start = System.currentTimeMillis();
        // 提供一个端异步执行的逻辑，然后封装到 CompletableFuture 中
        CompletableFuture<UserId> userIdFuture = CompletableFuture.supplyAsync(() -> new UserId(1), executor);

        // 异步将userId的输出，封装到 userDetail 的逻辑中
        CompletableFuture<UserDetails> userDetailsFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        return new UserDetails(userIdFuture.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, executor);

        // 计算完userDetail后，异步输出username的用户名
        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println(userDetailsFuture.get().getUsername());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }, executor);


        voidCompletableFuture.get();
        executor.shutdownNow();
/*
        CompletableFuture.
                supplyAsync(() -> new UserId(1), executor).
                thenApplyAsync(userId -> new UserDetails(userId), executor).
                thenAcceptAsync(userDetails -> System.out.println(userDetails.getUsername()), executor).
                get();
        executor.shutdownNow();*/
        System.out.println((System.currentTimeMillis()-start));
    }

    private static class UserId {
        private long id;
        public UserId(long id) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.id = id;
        }
    }
    private static class UserDetails {
        private UserId userId;
        public UserDetails(UserId userId) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.userId = userId;
        }
        public String getUsername() {
            // this can be replaced by a lookup based on userId
            return "some username";
        }
    }
}
