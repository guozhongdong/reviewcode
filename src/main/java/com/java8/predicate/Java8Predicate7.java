package com.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 *
 *
 *
 */
public class Java8Predicate7 {


    public static void main(String[] args) {
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");

        List<Hosting> list = Arrays.asList(new Hosting[]{h1,h2,h3,h4});

        List<Hosting> result = HostingRespository.filterHosting(list,x -> x.getName().startsWith("g"));
        System.out.println(result);

        List<Hosting> result2 = HostingRespository.filterHosting(list,isDeveloperFriendly());
        System.out.println(result2);
    }

    public static Predicate<Hosting> isDeveloperFriendly(){
        return n -> n.getName().equals("linode");
    }
}
