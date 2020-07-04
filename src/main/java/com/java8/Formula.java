package com.java8;

/**
 * @author gzd
 * @date 2019/10/29 下午2:42
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
