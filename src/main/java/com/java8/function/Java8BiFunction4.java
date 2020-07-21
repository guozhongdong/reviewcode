package com.java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author guozhongdong
 * @date 2020/7/21
 */
public class Java8BiFunction4 {

    public static void main(String[] args) {
        Java8BiFunction4 obj = new Java8BiFunction4();

        List<String> list = Arrays.asList("node","c++","java","javascript");
        List<String> result = obj.filterList(list,3, obj::filterByLength);
        //List<String> result = obj.filterList(list,3,obj::filterByLength);
        System.out.println(result);   // [node, java, javascript]

        List<String> result1 = obj.filterList(list,3, (list1,size2) -> {
            if (list1.length() > size2){
                return list1;
            }else{
                return null;
            }
        });
        System.out.println(result1);

        List<String> result2 = obj.filterList(list,"c", (list1,condi) -> {
            if (list1.startsWith(condi)){
                return list1;
            }else{
                return null;
            }
        });
        System.out.println(result2);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> result3 = obj.filterList(numbers,2, (list1,condi) -> {
            if (list1 % condi == 0){
                return list1;
            }else{
                return null;
            }
        });
        System.out.println(result3);
    }

    public String filterByLength(String str,Integer size){
        if (str.length() > size){
            return str;
        }else {
            return null;
        }
    }

    public <T,U,R> List<R> filterList(List<T> t1, U condition, BiFunction<T,U,R> func){
        List<R> result = new ArrayList<>();
        for (T t : t1) {
            R apply = func.apply(t,condition);
            if (apply != null){
                result.add(apply);
            }
        }
        return result;
    }
}
