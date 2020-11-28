package com.accumulate.coding.basic.reflect;

import java.lang.annotation.*;

/**
 * Author: Huaaaaaa
 * Date:  2020/11/28
 * Todo: 定义一个自动注入属性的注解
 * Time 11:28
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface AutoWiredField {
}
