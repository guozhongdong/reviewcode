package com.thread.chapter4.chpater4_3;

import com.thread.SleepUtils;

/**
 * @author gzd
 * @date create in 2019/1/8 18:20
 **/
public class Profiler {
    private static final ThreadLocal<Long> THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final Long end(){
        return System.currentTimeMillis()-THREADLOCAL.get();
    }

    public static void main(String[] args){
        Profiler.begin();
        SleepUtils.second(2);
        System.out.println("结束时间===="+(Profiler.end())+"ms");
    }

}
