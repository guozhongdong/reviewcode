package com.java8.compator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author guozhongdong
 * @date 2020/7/23
 *
 */

@Data
@AllArgsConstructor
public class Developer {

    private String name;

    private BigDecimal salary;

    private int age;
}
