package com.thread.chapter5.chapter5_4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gzd
 * @date create in 2019/1/10 15:29
 **/
public class Cache {

    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock r = lock.readLock();
    static Lock w = lock.writeLock();

    //获取读锁
    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }

    }
    public static final void put(String key,Object value){
        w.lock();
        try {
            map.put(key,value);
        }finally {
            w.unlock();
        }

    }

    public static final void clear(){
        w.lock();
        try {
            map.clear();
        }finally {
            w.unlock();
        }

    }
}
