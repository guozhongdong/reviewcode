package com.guava.cache;

import com.google.common.cache.*;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/10
 */
public class Rehash {

    public static void main(String[] args) throws ExecutionException {




        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            @Override
            public String load(String key) throws InterruptedException { // no checked exception
                System.out.println("初始化加载"+111);
                Thread.sleep(2000);
                return "123";
            }
        };





        LoadingCache<String, String> testCache  = CacheBuilder.newBuilder()
                .maximumSize(7)
                .expireAfterWrite(5,TimeUnit.SECONDS)
                //.refreshAfterWrite(4,TimeUnit.SECONDS)
                .build(loader);

        /*for (int i = 0; i < 10; i ++){
            String key = "key" + i;
            String value = "value" + i;

            System.out.println("[" + key + ":" + value + "] is put into cache!");
        }*/
        testCache.put("key","22221");
        testCache.put("key1","22222");
        testCache.put("key2","22223");
        testCache.put("key3","22224");
        try{
            System.out.println(testCache.get("key"));
            Thread.sleep(1000);
            System.out.println(testCache.get("key1"));
                Thread.sleep(1000);
            System.out.println(testCache.get("key2"));
                Thread.sleep(1000);
            System.out.println(testCache.get("key3"));
                Thread.sleep(1000);
            testCache.refresh();

            List<String> list = new ArrayList<>();
            list.add("mnkl");
            list.add("mnkl1");
            list.add("mnkl2");
            list.add("mnkl3");
            list.add("key7");
            //
            Thread.sleep(1000);
            System.out.println("===="+testCache.get("key"));
            System.out.println("====22244-----"+testCache.get("key1"));
            //System.out.println(testCache.get("key"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
