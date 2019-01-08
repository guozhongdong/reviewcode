package com.thread.chapter4.chpater4_3;

/**
 * @author gzd
 * @date create in 2019/1/8 15:55
 **/
public class Synchronized {

    public static void main(String[] args){

        synchronized (Synchronized.class) {
        }// 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }
    public static synchronized void m() {
    }
}
