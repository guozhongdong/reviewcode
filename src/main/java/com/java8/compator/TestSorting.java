package com.java8.compator;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 *
 * compator 接口 使用java8优化
 */
public class TestSorting {

    public static void main(String[] args) {
        List<Developer> listDevs = getDevelopers();
        System.out.println("Before Sort");
        for (Developer listDev : listDevs) {
            System.out.println(listDev);
        }
        //大众写法
        /*Collections.sort(listDevs, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("after Sort");
        for (Developer listDev : listDevs) {
            System.out.println(listDev);
        }*/
        //lambda 表达式
        //Collections.sort(listDevs, Comparator.comparingInt(Developer::getAge));
        // lambda 表达式最简化
        listDevs.sort(Comparator.comparingInt(Developer::getAge));


        Comparator<Developer> salaryComparator = Comparator.comparing(Developer::getSalary);

        listDevs.sort(salaryComparator);

        System.out.println("after Sort");
        for (Developer listDev : listDevs) {
            System.out.println(listDev);
        }

    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }
}
