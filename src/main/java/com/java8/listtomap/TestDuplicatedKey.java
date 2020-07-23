package com.java8.listtomap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 */
public class TestDuplicatedKey {

    public static void main(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(5, "mkyong.com", 4));
        // 重复的key，可以使用 toMap的重载方法，后面加一个计算方式，保留旧值还是保留新值
        Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,(oldValue,newValue) -> oldValue));

        System.out.println("Result 1 : " + result1);
    }

}
