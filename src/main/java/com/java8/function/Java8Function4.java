package com.java8.function;

import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @Description: list 转 list
 * @date 2020/7/22
 */
public class Java8Function4 {

    public static void main(String[] args) {
        Java8Function4 obj = new Java8Function4();
        List<String> list = Arrays.asList("c#","rust","java","javascript");

        List<String> map1 = obj.map(list,obj::getSha256);
        System.out.println(map1);
    }

    public <T,R> List<R> map(List<T> list,Function<T,R> func){

        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(func.apply(t));
        }
        return result;
    }

    public String getSha256(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
