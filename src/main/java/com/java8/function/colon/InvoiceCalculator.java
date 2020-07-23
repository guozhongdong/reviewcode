package com.java8.function.colon;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/22
 */
public class InvoiceCalculator {

    public BigDecimal normal(Invoice obj) {
        return obj.getUnitPrice().multiply(BigDecimal.valueOf(obj.qty));
    }

    public BigDecimal promotion(Invoice obj) {
        return obj.getUnitPrice()
                .multiply(BigDecimal.valueOf(obj.qty))
                .multiply(BigDecimal.valueOf(0.9))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
