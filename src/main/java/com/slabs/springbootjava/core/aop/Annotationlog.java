package com.slabs.springbootjava.core.aop;

import java.lang.annotation.*;

/**
 * @create: 2019/03/19 15:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Annotationlog {
    String remark() default "";
}
