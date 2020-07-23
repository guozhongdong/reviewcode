package com.java8.predicate;

import java.util.function.Predicate;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 * 组合链
 */
public class Java8Predicate6 {

    public static void main(String[] args) {
        Predicate<String> startWithA = x -> x.startsWith("a");

        boolean result = startWithA.or(x -> x.startsWith("m")).test("mkyog");
        System.out.println(result);

        boolean result2 = startWithA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);
    }
}
