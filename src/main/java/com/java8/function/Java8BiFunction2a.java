package com.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @date 2020/7/21
 *
 * BiFunction 传两个参数，
 * Function 传一个参数，验证这结合使用的效果
 * double 转成 string
 */
public class Java8BiFunction2a {

    public static void main(String[] args) {
        // 返回一个double类型
        BiFunction<Integer,Integer,Double> func1 = (v1,v2) -> Math.pow(v1,v2);

        Function<Double,String> func2 = (v1)-> "result is "+v1;
        // andThen 是接下来的意思，是先执行 func1的apply 方法，之后把结果当成参数传给 func2,
        // 类比 Function中的compose
        String str = func1.andThen(func2).apply(2,4);

        System.out.println(str);
    }
}
