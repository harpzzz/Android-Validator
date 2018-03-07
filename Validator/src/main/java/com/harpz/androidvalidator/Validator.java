package com.harpz.androidvalidator;


import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.harpz.androidvalidator.testValidator.EmailTest;
import com.harpz.androidvalidator.testValidator.MobileTest;
import com.harpz.androidvalidator.testValidator.NameTest;
import com.harpz.androidvalidator.testValidator.PasswordTest;
import com.harpz.androidvalidator.testValidator.RadioGroupTest;
import com.harpz.androidvalidator.validatorAnnotations.Checked;
import com.harpz.androidvalidator.validatorAnnotations.Email;
import com.harpz.androidvalidator.validatorAnnotations.Mobile;
import com.harpz.androidvalidator.validatorAnnotations.Name;
import com.harpz.androidvalidator.validatorAnnotations.Password;
import com.harpz.androidvalidator.validatorAnnotations.RadioCheck;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;



public class Validator {

    Activity activity;
    ArrayList<Object> alErrorView = new ArrayList<>();

    public Validator(Activity activity) {
        this.activity = activity;
    }

    public void validate(){


        alErrorView.clear();
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
                            alErrorView.add(edEmail);
                        }

            }else if(field.isAnnotationPresent(Name.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Name.class);
                Name iName = (Name) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iName.til());
                EditText edName = (EditText) field.get(activity);
                if(!new NameTest().checkValid(edName,iName.message(),tvInputLayout)){
                    alErrorView.add(edName);

                }
            }else if(field.isAnnotationPresent(Password.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Password.class);
                Password iPassword = (Password) annotation;
                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iPassword.til());
                EditText edPassword = (EditText) field.get(activity);
                if(!new PasswordTest().checkValid(edPassword,iPassword.message(),tvInputLayout)){
                    alErrorView.add(edPassword);
                }
            }else if(field.isAnnotationPresent(Checked.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Checked.class);
                Checked iChecked = (Checked) annotation;

                try {
                    CheckBox checkBox = (CheckBox) field.get(activity);
                    if(!checkBox.isChecked()){
                        Toast.makeText(activity, iChecked.message(), Toast.LENGTH_SHORT).show();
                        alErrorView.add(checkBox);
                    }
                }catch (ClassCastException ex){
                    ex.printStackTrace();
                }


            }else if(field.isAnnotationPresent(RadioCheck.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(RadioCheck.class);
                RadioCheck iRadioGroup = (RadioCheck) annotation;

                RadioGroup radioGroup = (RadioGroup) field.get(activity);
                RadioGroupTest radioGroupTest = new RadioGroupTest();
                    if(radioGroupTest.checkRadio(radioGroup)){
                        Toast.makeText(activity, iRadioGroup.message(), Toast.LENGTH_SHORT).show();
                        alErrorView.add(radioGroup);
                    }

            }else if(field.isAnnotationPresent(Mobile.class)){
                field.setAccessible(true);

                Annotation annotation = field.getAnnotation(Mobile.class);
                Mobile iMobile = (Mobile) annotation;

                EditText edMobile = (EditText) field.get(activity);
                MobileTest mobileTest = new MobileTest();

                TextInputLayout tvInputLayout = (TextInputLayout) activity.findViewById(iMobile.til());

                if(!mobileTest.mobileNumValid(edMobile, iMobile.message(),iMobile.regex(),tvInputLayout)){
                    alErrorView.add(edMobile);
                }

            }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }

            ValidatorListener validatorListener = (ValidatorListener) activity;

            if(alErrorView.size() > 0) {
                validatorListener.onValidateFailed(alErrorView);
            }else {
                validatorListener.onValidateSuccess();
            }



    }

}


