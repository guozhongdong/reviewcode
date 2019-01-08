package com.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzd
 * @create 2018-11-02 10:11
 * @desc
 **/
public class DemoTest {

    public static void main(String[] args){
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        demo1.setId(100);
        demo2.setId(100);

        System.out.println(demo1.equals(demo2));

        Set<Demo> set = new HashSet<Demo>();
        set.add(demo1);
        set.add(demo2);
        System.out.println(set);
    }
}
