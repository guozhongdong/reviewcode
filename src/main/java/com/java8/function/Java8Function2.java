package com.java8.function;

import java.util.function.Function;

/**
 * @author guozhongdong
 * @date 2020/7/22
 *
 * addThen
 */
public class Java8Function2 {

    public static void main(String[] args) {

        Function<String,Integer> func1 = x -> x.length();
        Function<Integer,Integer> func2 = x -> x*2;

        Integer apply = func1.andThen(func2).apply("mnklo");
        System.out.println(apply); // 10
    }
}
