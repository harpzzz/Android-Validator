package com.harpz.androidvalidator.validatorAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Name{
    String message() default "Please enter the valid Name.";
    int til() default -1;
}
