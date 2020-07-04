package com.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2019/10/29 下午3:44
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("aaa1");
        stringList.add("bbb2");
        stringList.add("bbb1");
        stringList.add("ccc2");
        stringList.add("ccc3");
        stringList.add("ccc1");
        stringList.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
        // 测试map操作
        stringList.stream().map(String::toUpperCase).sorted((a,b) -> a.compareTo(b)).forEach(System.out::println);
        // match 匹配

    }
}
