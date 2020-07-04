package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author gzd
 * @date 2019/10/29 下午2:44
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter","anna","mike","paul");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(names,(String o1,String o2) -> o1.compareTo(o2));

        names.sort((a,b) -> b.compareTo(a));

        Function<String,Integer> toInteger = Integer::valueOf;
    }
}
