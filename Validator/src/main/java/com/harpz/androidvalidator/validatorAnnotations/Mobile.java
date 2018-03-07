package com.harpz.androidvalidator.validatorAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by harpreet on 6/3/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mobile {

    String message() default "Please enter valid Mobile Number";

    String regex() default  "^[0-9]{10}$";

    int til() default -1;

}
