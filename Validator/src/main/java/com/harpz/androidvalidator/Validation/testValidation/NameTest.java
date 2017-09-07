package com.harpz.androidvalidator.Validation.testValidation;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class NameTest {

    String namepattern = "[a-zA-Z ]+";


    public void checkValid(final EditText eName, final String message, final TextInputLayout til){

        if(eName != null) {

            if(til != null) {
                til.setErrorEnabled(false);
                eName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            final String check = eName.getText().toString().trim();

                            if (!namevalidation(check)) {
                                til.setErrorEnabled(true);
                                til.setError(message);

                            } else {
                                til.setErrorEnabled(false);
                                til.setError(null);
                            }

                        }
                    }
                });

            }else{

                eName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            final String check = eName.getText().toString().trim();

                            if (!namevalidation(check)) {

                                eName.setError("Please enter valid Name.");
                            } else {
                                eName.setError(null);

                            }

                        }
                    }
                });

            }

        }else{
            throw new NullPointerException("Validator : Field is null");
        }

    }


   boolean namevalidation(String sName){

//Minimum 3 Character
        if(sName.length() <= 2){

            return false;
        }else {

            Pattern pattern = Pattern.compile(namepattern);
            Matcher matcher = pattern.matcher(sName);

            return matcher.matches();

        }
    }
}
