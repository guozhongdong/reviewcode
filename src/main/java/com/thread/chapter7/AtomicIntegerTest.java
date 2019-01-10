package com.thread.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gzd
 * @date create in 2019/1/10 17:30
 **/
public class AtomicIntegerTest {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(1);

        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.get());

    }
}
