package com.java8.function;

import java.util.function.BiFunction;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/21
 */
public class Java8BiFunction3 {

    public static void main(String[] args) {
        GPS gps = Java8BiFunction3.factory("40.741895", "-73.989308", GPS::new);
        System.out.println(gps);
    }
    public static <R extends GPS> R factory(String Latitude, String Longitude,
                                           BiFunction<String,String,R> func1){
        return func1.apply(Latitude,Longitude);
    }
}
