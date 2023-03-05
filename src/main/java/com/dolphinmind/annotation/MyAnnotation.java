package com.dolphinmind.annotation;

import java.lang.annotation.*;

/* 自定义注解
 */
@Target(ElementType.TYPE)               //用于描述注解的使用范围
@Retention(RetentionPolicy.RUNTIME)     //用于需要在什么级别保存该注释信息(RUNTIME>CLASS>SOURCE)
@Inherited                              //子类可继承父类的该注解
@Documented                             //包含在javadoc文档中
public @interface MyAnnotation {
    String name() default "";
    int age() default 0;
    int index() default -1;

    String[] schools();
}

