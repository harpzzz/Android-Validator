package com.harpz.androidvalidator.Validation;


import android.app.Activity;
import android.widget.EditText;

import com.harpz.androidvalidator.Validation.testValidation.EmailTest;
import com.harpz.androidvalidator.Validation.testValidation.NameTest;
import com.harpz.androidvalidator.Validation.testValidation.PasswordTest;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Email;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Name;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Password;

import java.lang.reflect.Field;




public class Validator {




    public void Validator(Activity activity) {

        Class cl = activity.getClass();


        Field[] fd = cl.getDeclaredFields();

        for (int i = 0; i < fd.length; i++) {

            try {

            if (fd[i].isAnnotationPresent(Email.class)) {
                fd[i].setAccessible(true);
                EditText editText = (EditText) fd[i].get(activity);
                    new EmailTest().checkValid(editText);
            }else if(fd[i].isAnnotationPresent(Name.class)){
                fd[i].setAccessible(true);
                EditText editText = (EditText) fd[i].get(activity);
                new NameTest().checkValid(editText);
            }else if(fd[i].isAnnotationPresent(Password.class)){
                fd[i].setAccessible(true);
                EditText editText = (EditText) fd[i].get(activity);
                new PasswordTest().checkValid(editText);
                }

            } catch (IllegalArgumentException ex) {

            } catch (IllegalAccessException ex) {
            }


        }
    }




}
