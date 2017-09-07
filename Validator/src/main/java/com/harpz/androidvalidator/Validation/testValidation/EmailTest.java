package com.harpz.androidvalidator.Validation.testValidation;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class EmailTest {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public void checkValid(final EditText email, final String message, final TextInputLayout til){

        if(email != null) {

            if(til != null){

                til.setErrorEnabled(false);
                email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            final String check = email.getText().toString().trim();

                            if (!emailValidation(check)) {
                                til.setErrorEnabled(true);
                                til.setError(message);
                            } else {
                                til.setError(null);
                                til.setErrorEnabled(false);
                            }

                        }
                    }
                });

            }else {

                email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            final String check = email.getText().toString().trim();

                            if (!emailValidation(check)) {
                                email.setError(message);
                            } else {
                                email.setError(null);
                            }

                        }
                    }
                });
            }

        }else{

            throw new NullPointerException("Validator : Field is null");
        }

    }


    boolean emailValidation(String s) {
        if (s.matches(emailPattern)) {
            return true;
        } else {
            return false;
        }
    }
}
