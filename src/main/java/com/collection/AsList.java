package com.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author gzd
 * @date 2019/6/10 下午3:11
 *
 * asList 的缺陷
 */
public class AsList {

    public static void main(String[] args) {
        //一、避免使用基本数据类型数组转换为列表
        /*int[] ints = {1,2,3,4,5};
        List list = Arrays.asList(ints);
        System.out.println("list'size：" + list.size());*/
        // list 里存放的就是ints 数组对象，不是具体的元素
        // 不要把基本类型数组 当做参数
        //============================================
        // 二、asList 产生的列表不可操作
        /**
         * asList 返回的list 是 Arrays 的一个内部类 ArrayList ，没有给提供add方法，
         * */
        Integer[] ints = {1,2,3,4,5};
        List list = Arrays.asList(ints);
        list.add(8);
    }
}
