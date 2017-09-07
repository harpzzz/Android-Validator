package com.harpz.androidvalidator.Validation.validatorInterfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Email {

    String message() default "Please Check your email is not valid";
    int til() default -1;
}
