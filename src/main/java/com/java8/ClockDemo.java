package com.java8;

import java.time.Clock;
import java.time.Instant;

/**
 * @author gzd
 * @date 2019/10/29 下午3:59
License key is in legacy format Help
 */
public class ClockDemo {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long mills = clock.millis();
        System.out.println(mills);

        Instant instant = clock.instant();
        System.out.println(instant);
    }
}
