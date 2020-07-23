package com.java8.function;

import java.util.function.Function;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
public class Function1 {

    public static void main(String[] args) {

        Function<String,Integer> func = x -> x.length();
        System.out.println(func.apply("abcdef"));
    }
}
