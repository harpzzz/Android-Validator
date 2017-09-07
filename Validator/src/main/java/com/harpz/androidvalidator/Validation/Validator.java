package com.harpz.androidvalidator.Validation;


import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.widget.CheckBox;
import android.widget.EditText;

import com.harpz.androidvalidator.Validation.testValidation.CheckedBoxTest;
import com.harpz.androidvalidator.Validation.testValidation.EmailTest;
import com.harpz.androidvalidator.Validation.testValidation.NameTest;
import com.harpz.androidvalidator.Validation.testValidation.PasswordTest;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Checked;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Email;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Name;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Password;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;




public class Validator {




    public void validate(Activity activity) {

        Class cl = activity.getClass();


        Field[] fd = cl.getDeclaredFields();

        for (int i = 0; i < fd.length; i++) {

            try {

            if (fd[i].isAnnotationPresent(Email.class)) {
                fd[i].setAccessible(true);

                Annotation annotation = fd[i].getAnnotation(Email.class);
                Email iEmail = (Email) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iEmail.til());
                EditText editText = (EditText) fd[i].get(activity);
                    new EmailTest().checkValid(editText,iEmail.message(),tvInputLayout);
            }else if(fd[i].isAnnotationPresent(Name.class)){
                fd[i].setAccessible(true);

                Annotation annotation = fd[i].getAnnotation(Name.class);
                Name iName = (Name) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iName.til());
                EditText editText = (EditText) fd[i].get(activity);
                new NameTest().checkValid(editText,iName.message(),tvInputLayout);
            }else if(fd[i].isAnnotationPresent(Password.class)){
                fd[i].setAccessible(true);

                Annotation annotation = fd[i].getAnnotation(Password.class);
                Password iPassword = (Password) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iPassword.til());
                EditText editText = (EditText) fd[i].get(activity);
                new PasswordTest().checkValid(editText,iPassword.message(),tvInputLayout);
            }else if(fd[i].isAnnotationPresent(Checked.class)){
                Annotation annotation = fd[i].getAnnotation(Checked.class);
                fd[i].setAccessible(true);
                Checked iChecked = (Checked) annotation;
                CheckBox checkBox = (CheckBox) fd[i].get(activity);
                new CheckedBoxTest().checkValid(checkBox,iChecked.message());
            }

            } catch (IllegalArgumentException ex) {

            } catch (IllegalAccessException ex) {
            }


        }
    }




}
