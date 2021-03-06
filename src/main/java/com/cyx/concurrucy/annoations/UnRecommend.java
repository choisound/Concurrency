package com.cyx.concurrucy.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 注解标识某种写法是系统不推荐的
* */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface UnRecommend {
    String value() default "";
}
