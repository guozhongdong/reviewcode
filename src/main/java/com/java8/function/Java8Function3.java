package com.java8.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @Description: list 转 map
 * @date 2020/7/22
 */
public class Java8Function3 {

    public static void main(String[] args) {

        Java8Function3 func3 = new Java8Function3();
        List<String> list = Arrays.asList("c#","java","net","javascript");
        Map<String,Integer> map = func3.convertMap(list,x-> x.length());
        // func:: getLength java8方法调用
        // 这个方法满足输入一个参数，返回一个结果
        Map<String,Integer> map2 = func3.convertMap(list,func3::getLength);
        System.out.println(map);
        System.out.println(map2);

    }
    public <T,R> Map<T,R> convertMap(List<T> list, Function<T,R> func){
        Map<T,R> map = new HashMap<>();
        for (T t : list) {
            map.put(t,func.apply(t));
        }
        return map;
    }

    public Integer getLength(String str){
        return str.length();
    }

}
