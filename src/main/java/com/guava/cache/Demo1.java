package com.guava.cache;

import com.google.common.cache.*;
import org.checkerframework.checker.units.qual.K;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author guozhongdong
 * @date 2020/7/10
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException {

        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            @Override
            public String load(String key) throws Exception {
                Thread.sleep(1000);
                if("key".equals(key)){
                    return null;
                }

                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }

            @Override
            public Map loadAll(Iterable keys) throws Exception {
                Thread.sleep(1000);
                Map map = new HashMap();
                Iterator it = keys.iterator();
                while (it.hasNext()){
                    System.out.println(" all nulls");
                    map.put(it.next(),"123");
                }

                System.out.println(map);
                return map;
            }
        };

        RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> removal) {
                System.out.println("[" + removal.getKey() + ":" + removal.getValue() + "] is evicted!");
            }
        };

        LoadingCache<String, String> testCache  = CacheBuilder.newBuilder()
                .maximumSize(7)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(removalListener)
                .build(loader);

        for (int i = 0; i < 10; i ++){
            String key = "key" + i;
            String value = "value" + i;
            testCache.put(key,value);
            System.out.println("[" + key + ":" + value + "] is put into cache!");
        }

        System.out.println(testCache.getIfPresent("key6"));
        System.out.println(testCache.get("key6"));

        try{
            List<String> list = new ArrayList<>();
            list.add("mnkl");
            list.add("mnkl1");
            list.add("mnkl2");
            list.add("mnkl3");
            list.add("key7");
            //

            System.out.println("===="+testCache.getAll(list));
            System.out.println(testCache.get("key"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
