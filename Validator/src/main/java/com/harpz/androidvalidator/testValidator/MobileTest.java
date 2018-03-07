package com.harpz.androidvalidator.testValidator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by harpreet on 6/3/18.
 */

public class MobileTest {


    public boolean mobileNumValid(EditText edMobile, String message, String regex , TextInputLayout til){

        if(edMobile != null) {



                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(edMobile.getText().toString().trim());


                if(til != null) {
                    til.setErrorEnabled(false);

                    if (!matcher.matches()) {
                        til.setErrorEnabled(true);
                        til.setError(message);

                    } else {
                        til.setErrorEnabled(false);
                        til.setError(null);
                    }


                }else{


                    if (!matcher.matches()) {

                        edMobile.setError("Please enter valid Mobile Number.");
                    } else {
                        edMobile.setError(null);

                    }

                }


                return matcher.matches();



            }


        return false;


    }
}
