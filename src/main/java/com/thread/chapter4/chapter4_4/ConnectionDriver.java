package com.thread.chapter4.chapter4_4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author gzd
 * @date create in 2019/1/8 20:44
 **/
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler{
        public Object invoke(Object proxy, Method method, Object[] args) throws InterruptedException {
            if (method.getName().equals("commit")){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class[]
                {Connection.class},new ConnectionHandler());
    }
}
