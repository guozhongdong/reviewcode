package com.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 *
 *
 */
public class Java8Predicate5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        System.out.println(StringProcessor.filter(list,x-> x.startsWith("A")));
        System.out.println(StringProcessor.filter(list,x-> x.startsWith("A") && x.length() ==3));

    }

}
class StringProcessor{
    static List<String> filter(List<String> list , Predicate<String> predicate){
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }
}
