package com.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

    String value() default "";
}
