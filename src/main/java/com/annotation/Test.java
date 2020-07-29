package com.annotation;

import java.lang.annotation.*;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:20 2020/7/3
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Test {
    String value() default "";
}
