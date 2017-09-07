package com.harpz.androidvalidator.Validation.validatorInterfaces;


public @interface Password {

    String message() default "Please enter minimum 8 characters.";
    int til() default -1;
}
