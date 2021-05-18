package com.example.springexamples.example04.aopadvanced;

import org.springframework.stereotype.Repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAuthority {
    public enum MyAuthorityType {
        USER, ADMIN, SUPERADMIN
    }
    MyAuthorityType[] value() default MyAuthorityType.USER;
    String key() default "";


}

