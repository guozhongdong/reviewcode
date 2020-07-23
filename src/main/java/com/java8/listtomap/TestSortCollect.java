package com.java8.listtomap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 *
 * 排序map
 */
public class TestSortCollect {

    public static void main(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "linode.com", 100000));

        Map<String,Long> map = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(Collectors.toMap(Hosting::getName,Hosting::getWebsites,
                        (oldValue,newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(map);

    }

}
