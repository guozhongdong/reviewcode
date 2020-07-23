package com.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:多个条件 and 计算
 * @date 2020/7/23
 */
public class Java8Predicate2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //多个条件过滤
        List<Integer> result = list.stream().filter(x -> x > 5 && x < 8).collect(Collectors.toList());
        System.out.println(result);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> pre = x -> x>5;
        Predicate<Integer> andPre = x -> x<10;
        //多个条件过滤
        List<Integer> result1 = list1.stream().filter(pre.and(andPre)).collect(Collectors.toList());
        System.out.println(result1);

    }

}
