package com.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @date 2020/7/21
 */
public class Java8BiFunction2c {


    public static void main(String[] args) {
        //获取两个int值的double 平方值，double类型转为String
        String result = convert(2,4,(v1,v2)-> Math.pow(v1,v2),(r)-> "Result : " +String.valueOf(r) );
        System.out.println(result);

        String result1 = convert(2,4,(v1,v2)-> v1*v2,(r)-> "Result : " +String.valueOf(r) );
        System.out.println(result1);
        // 传两个String 类型加上 "cde"
        String result2 = convert("a","b",(v1,v2)-> v1+v2,(r)-> r+"cde" );
        System.out.println(result2);

        // 传两个String 将结果转换为Integer
        Integer result3 = convert("100","200",(v1,v2)-> v1+v2,(r)-> Integer.valueOf(r));
        System.out.println(result3);
    }

    public static <A1,A2,R1,R2> R2 convert(A1 a1, A2 a2,
                                           BiFunction<A1,A2,R1> func1,
                                           Function<R1, R2> func2){
        return func1.andThen(func2).apply(a1,a2);
    }
}
