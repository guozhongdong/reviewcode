package com.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/10
 */
public class Demo2 {

    static Cache<String, String> testCache  = CacheBuilder.newBuilder()
            .maximumSize(7)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    public static void main(String[] args) throws ExecutionException {
        testCache.put("123","5555");

        System.out.println(testCache.getIfPresent("123"));

        System.out.println(testCache.get("1233", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "6666";
            }
        }));

        System.out.println(testCache.get("123", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "6666";
            }
        }));

    }

}
