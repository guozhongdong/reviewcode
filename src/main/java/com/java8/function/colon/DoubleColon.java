package com.java8.function.colon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 *
 * lambda 表达式双引号的作用
 */
public class DoubleColon {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("node", "java", "python", "ruby");
        list.forEach(new Consumer<String>() {       // anonymous class
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });

        //lambda
        // anonymous class
        list.forEach(str -> System.out.println(str));

        //method reference
        list.forEach(System.out::println);
    }
}
