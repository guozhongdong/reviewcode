package com.java8.function.colon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
@Data
@AllArgsConstructor
public class Invoice {


    public Invoice(){

    }

    public Invoice(BigDecimal unitPrice){
        this.unitPrice = unitPrice;
    }

     String no;

     BigDecimal unitPrice;

     Integer qty;
}
