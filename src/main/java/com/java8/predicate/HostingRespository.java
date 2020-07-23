package com.java8.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 */
public class HostingRespository {

    public static List<Hosting> filterHosting(List<Hosting> list, Predicate<Hosting> predicate){

        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
