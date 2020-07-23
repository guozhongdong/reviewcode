package com.java8.listtomap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @date 2020/7/23
 * list 转 map
 *
 */
public class TestListMap {

    public static void main(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        // key是id，value是 website
        Map<Integer,String> map = list.stream().collect(Collectors.toMap(Hosting::getId,Hosting::getName));
        Map<String,Long> map1 = list.stream().collect(Collectors.toMap(Hosting::getName,Hosting::getWebsites));
        Map<String,Long> map2 = list.stream().collect(Collectors.toMap(x -> x.getName(),Hosting::getWebsites));

        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
    }
}
