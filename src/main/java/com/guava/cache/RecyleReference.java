package com.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author guozhongdong
 * @date 2020/7/10
 *
 * 缓存回收---基于引用回收
 * 熟悉引用的几种类型，各自的区别
 * 强
 * 软
 * 弱
 * 虚
 *
 *
 */
public class RecyleReference {

    static Cache<String, String> testCache  = CacheBuilder.newBuilder()
            .maximumSize(2)
            .refreshAfterWrite(Duration.ofHours(12))
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .weakKeys()
            .build();

    public static void main(String[] args) {
        testCache.put("1","kkkk");
        testCache.put("2","kkkk123");// 回收
        testCache.put("3","kkkk444");
        testCache.put("4","kkkk555");


        System.out.println(testCache.getIfPresent("4"));
        System.out.println(testCache.getIfPresent("3"));
        System.out.println(testCache.getIfPresent("2"));
        System.out.println(testCache.getIfPresent("1"));
    }
}
