package com.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author guozhongdong
 * @date 2020/7/10
 *
 * 缓存回收---基于定时回收
 *
 */
public class RecyleTime {

    static Cache<String, String> testCache  = CacheBuilder.newBuilder()
            .maximumSize(4)
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) throws InterruptedException {
        testCache.put("1","kkkk");
        testCache.put("2","kkkk123");// 回收
        testCache.put("3","kkkk444");
        testCache.put("4","kkkk555");

        Thread.sleep(5000);
        System.out.println(testCache.getIfPresent("4"));
        Thread.sleep(6000);
        System.out.println(testCache.getIfPresent("4"));
        System.out.println(testCache.getIfPresent("3"));
        System.out.println(testCache.getIfPresent("2"));
        System.out.println(testCache.getIfPresent("1"));
    }
}
