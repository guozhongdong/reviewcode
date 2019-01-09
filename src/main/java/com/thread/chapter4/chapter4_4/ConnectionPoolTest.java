package com.thread.chapter4.chapter4_4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gzd
 * @date create in 2019/1/8 20:56
 **/
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end ;
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 100;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger noGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,noGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke:"+(threadCount * count));
        System.out.println("got connection:"+got);
        System.out.println("not got connection:"+noGot);

    }

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger noGot;

        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger noGot){
            this.count = count;
            this.got = got;
            this.noGot = noGot;
        }
        public void run(){
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    }else {
                        noGot.incrementAndGet();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }

            }
            end.countDown();
        }
    }
}
