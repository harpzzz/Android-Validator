package com.harpz.androidvalidator;


import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import com.harpz.androidvalidator.testValidator.EmailTest;
import com.harpz.androidvalidator.testValidator.NameTest;
import com.harpz.androidvalidator.testValidator.PasswordTest;
import com.harpz.androidvalidator.validatorAnnotations.Email;
import com.harpz.androidvalidator.validatorAnnotations.Name;
import com.harpz.androidvalidator.validatorAnnotations.Password;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;



public class Validator {

    Activity activity;
    ArrayList<EditText> alEditText = new ArrayList<>();

    public Validator(Activity activity) {
        this.activity = activity;
    }

    public void validate(){


        alEditText.clear();
        Class cl = activity.getClass();

        Field[] fd = cl.getDeclaredFields();

        for(int i=0; i< fd.length;i++){

            try {

            Field field = fd[i];

            if(field.isAnnotationPresent(Email.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Email.class);
                Email iEmail = (Email) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iEmail.til());

                    EditText edEmail = (EditText) field.get(activity);

                        if(!new EmailTest().checkValid(edEmail,iEmail.message(),tvInputLayout)){
                            alEditText.add(edEmail);
                        }

            }else if(field.isAnnotationPresent(Name.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Name.class);
                Name iName = (Name) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iName.til());
                EditText edName = (EditText) field.get(activity);
                if(!new NameTest().checkValid(edName,iName.message(),tvInputLayout)){
                    alEditText.add(edName);

                }
            }else if(field.isAnnotationPresent(Password.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Password.class);
                Password iPassword = (Password) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iPassword.til());
                EditText edPassword = (EditText) field.get(activity);
                if(!new PasswordTest().checkValid(edPassword,iPassword.message(),tvInputLayout)){
                    alEditText.add(edPassword);
                }
            }/*else if(field.isAnnotationPresent(Checked.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Checked.class);
                Checked iChecked = (Checked) annotation;

                try {
                    CheckBox checkBox = (CheckBox) field.get(activity);
                    if(!checkBox.isChecked()){
                        Toast.makeText(activity, iChecked.message(), Toast.LENGTH_SHORT).show();
                       // alEditText.add(checkBox);
                    }
                }catch (ClassCastException ex){
                    ex.printStackTrace();
                }


            }*/
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }

            ValidatorListener validatorListener = (ValidatorListener) activity;

            if(alEditText.size() > 0) {
                validatorListener.onValidateFailed(alEditText);
            }else {
                validatorListener.onValidateSuccess();
            }



    }

}


