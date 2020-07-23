package com.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 *
 * java8 函数式接口，给定一个参数，返回一个boolean 类型，主要是过滤集合内的元素
 */
public class Java8Predicate {

    public static void main(String[] args) {
        // filter 方法
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = list.stream().filter(x -> x>5).collect(Collectors.toList());
        System.out.println(result);
    }

}
