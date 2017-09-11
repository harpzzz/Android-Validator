package com.harpz.androidvalidator.testValidator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class EmailTest {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean checkValid(final EditText email, final String message, final TextInputLayout til){

        if(email != null) {

            String check = email.getText().toString().trim();

            if(til != null){

                            til.setErrorEnabled(false);

                            if (!emailValidation(check)) {
                                til.setErrorEnabled(true);
                                til.setError(message);
                            } else {
                                til.setError(null);
                                til.setErrorEnabled(false);
                            }
            }else {
                            if (!emailValidation(check)) {
                                email.setError(message);
                            } else {
                                email.setError(null);
                            }

            }


            return emailValidation(check);

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
