package com.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @date 2020/7/21
 * 把BiFunction 和Function 整合到一起
 */
public class Java8BiFunction2b {

    public static void main(String[] args) {

        String str = powString(2,4,(v1,v2)-> Math.pow(v1,v2),(r)-> "Result : " +String.valueOf(r) );
        String str1 = convert(2,4,(v1,v2)-> Math.pow(v1,v2),(r)-> "Result : " +String.valueOf(r) );
        System.out.println(str);
        System.out.println(str1);
    }

    public static <R> R powString(Integer a1, Integer a2,
                                  BiFunction<Integer,Integer,Double> func1,
                                  Function<Double, R> func2){
        return func1.andThen(func2).apply(a1,a2);
    }

    //上面这个方法可以做一个通用的接口

    public static <A1,A2,R1,R2> R2 convert(A1 a1, A2 a2,
                                           BiFunction<A1,A2,R1> func1,
                                           Function<R1, R2> func2){
        return func1.andThen(func2).apply(a1,a2);
    }
}
