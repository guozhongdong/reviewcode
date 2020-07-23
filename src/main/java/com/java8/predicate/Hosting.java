package com.java8.predicate;

import lombok.Data;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 */
@Data
public class Hosting {

    private int Id;
    private String name;
    private String url;

    public Hosting(int id, String name, String url) {
        Id = id;
        this.name = name;
        this.url = url;
    }
}
