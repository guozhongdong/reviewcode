package com.java8.function.colon;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
public class Java8MethodReference3a {
    public static void main(String[] args) {
        /*String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String s : stringArray) {
            System.out.print(s+" ");
        }*/
        Integer result = playOneArgument("mnklo",x -> x.length());
        Integer result1 = playOneArgument("mnklo", String::length);

        Boolean result2 = playTwoArgument("mnklo","k",(a,b) -> a.contains(b));
        Boolean result3 = playTwoArgument("mnklo","k", String::contains);

        Boolean result4 = playTwoArgument("mnklo","r",(a,b) -> a.startsWith(b));
        Boolean result5 = playTwoArgument("mnklo","m", String::startsWith);

        System.out.println(result5);
    }

    static <R> R playOneArgument(String r1, Function<String,R> func){
        return func.apply(r1);
    }

    static Boolean playTwoArgument(String s1, String s2, BiPredicate<String,String> pre){

        return pre.test(s1,s2);
    }
}
