package com.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 * negate
 * 关联or 计算
 * negate 否定
 *
 */
public class Java8PredicateOr {

    public static void main(String[] args) {
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect = list.stream()
                .filter(lengthIs3.or(startWithA))
                .collect(Collectors.toList());

        System.out.println(collect);

        Predicate<String> startWithA1 = x -> x.startsWith("A");

        List<String> list1 = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect1 = list1.stream()
                .filter(startWithA1.negate())
                .collect(Collectors.toList());

        System.out.println(collect1);
    }
}
