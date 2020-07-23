package com.java8.function.colon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
public class Java8MethodReference3b {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("A001", BigDecimal.valueOf(1.99),3);
        InvoiceCalculator formula = new InvoiceCalculator();

        BigDecimal result =  calculate(formula,invoice,(f,o) -> f.normal(o));
        BigDecimal result2 =  calculate(formula,invoice,InvoiceCalculator::normal);

        BigDecimal result3 =  calculate(formula,invoice,(f,o) -> f.promotion(o));
        BigDecimal result4 =  calculate(formula,invoice,InvoiceCalculator::promotion);


        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    static BigDecimal calculate(InvoiceCalculator formula, Invoice s1, BiFunction<InvoiceCalculator,Invoice,BigDecimal> func){

        return func.apply(formula,s1);
    }

}
