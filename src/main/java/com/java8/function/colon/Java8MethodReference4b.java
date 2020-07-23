package com.java8.function.colon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
public class Java8MethodReference4b {
    public static void main(String[] args) {
        List<BigDecimal> list = Arrays.asList(
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(2.99),
                BigDecimal.valueOf(8.99));

        List<Invoice> invoices = fakeInvoice(list,Invoice::new);
        invoices.forEach(System.out::println);

    }
    static List<Invoice> fakeInvoice(List<BigDecimal> list, Function<BigDecimal,Invoice> func){
        List<Invoice> result = new ArrayList<>();
        for (BigDecimal bigDecimal : list) {
            result.add(func.apply(bigDecimal));
        }
        return result;
    }

}
