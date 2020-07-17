package com.guava.cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * @author guozhongdong
 * @date 2020/7/10
 *
 * 移除监听器，记录日志，可装饰为异步操作
 */
public class RemoveListener {

    public static void main(String[] args) {
        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            @Override
            public String load(String key) throws Exception {
                return "123";
            }
        };


        RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> removal) {
                String conn = removal.getValue();
                System.out.println(conn);
            }
        };

        LoadingCache<String, String> testCache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .removalListener(removalListener)
                .build(loader);

        testCache.put("12312","5555");
        testCache.put("12345","6666");

    }

}
