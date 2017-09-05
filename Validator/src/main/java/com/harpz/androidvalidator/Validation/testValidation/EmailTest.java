package com.harpz.androidvalidator.Validation.testValidation;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class EmailTest {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public void checkValid(final EditText email){

        if(email != null) {

            email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus){
                        final String check = email.getText().toString().trim();

                        if (!emailValidation(check)) {
                            email.setError("Please Check Your email");
                            email.requestFocus();
                        } else {
                            email.setError(null);
                            email.setFocusable(false);
                        }

                    }
                }
            });

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
