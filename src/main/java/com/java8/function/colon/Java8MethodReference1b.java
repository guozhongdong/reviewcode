package com.java8.function.colon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
public class Java8MethodReference1b {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");

        // anonymous class
        List<Integer> collect1 = list.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .collect(Collectors.toList());

        // lambda expression
        List<Integer> collect2 = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        // method reference
        List<Integer> collect3 = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());


    }
}
