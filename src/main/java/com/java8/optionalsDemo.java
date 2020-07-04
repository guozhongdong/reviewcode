package com.java8;

import java.util.Optional;

/**
 * @author gzd
 * @date 2019/10/29 下午3:14
 */
public class optionalsDemo {

    public static void main(String[] args) {

        User u = new User();
        u.name = "ke";
        System.out.println(getName(u));

    }

    public static String getName(User u) {

       return Optional.ofNullable(u).map(user -> user.name).orElse("Unknown");
    }

}
