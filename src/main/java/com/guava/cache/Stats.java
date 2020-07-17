package com.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author guozhongdong

 * @date 2020/7/10
 * 统计
 *
 * null
 * CacheStats{hitCount=0, missCount=1, loadSuccessCount=0, loadExceptionCount=0, totalLoadTime=0, evictionCount=0}
 */
public class Stats {

    static Cache<String, Object> testCache = CacheBuilder.newBuilder()
            .weakValues()
            .recordStats() //统计
            .build();

    public static void main(String[] args) {
        Object obj1 = new Object();

        testCache.put("1234",obj1);

        obj1 = new String("123");

        System.gc();

        System.out.println(testCache.getIfPresent("1234"));

        System.out.println(testCache.stats());
    }
}
