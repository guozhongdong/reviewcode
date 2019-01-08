package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author gzd
 * @date create in 2019/1/6 23:11
 **/
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
