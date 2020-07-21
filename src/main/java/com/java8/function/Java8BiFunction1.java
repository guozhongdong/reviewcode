package com.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author guozhongdong
 * @date 2020/7/21
 */
public class Java8BiFunction1 {

    public static void main(String[] args) {
        // 计算两个数值 ，返回一个Integer类型的
        BiFunction<Integer,Integer,Integer> bi = (v1,v2) -> v1+v2;
        Integer obj = bi.apply(2,4);
        System.out.println(obj);
        // 返回一个double类型的
        BiFunction<Integer,Integer,Double> bi1 = (v1,v2) -> Math.pow(v1,v2);
        Double obj2 = bi1.apply(2,4);
        System.out.println(obj2);

        // 返回一个集合
        BiFunction<Integer,Integer, List<Integer>> bi2 = (v1, v2) -> Arrays.asList(v1+v2);
        List<Integer> obj3 = bi2.apply(2,4);
        System.out.println(obj3);
    }
}
