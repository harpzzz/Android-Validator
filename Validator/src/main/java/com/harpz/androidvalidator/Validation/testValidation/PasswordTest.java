package com.harpz.androidvalidator.Validation.testValidation;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class PasswordTest {



    public void checkValid(final EditText ePassword, final String message, final TextInputLayout til){
        if(ePassword != null) {

            if(til != null) {

                til.setErrorEnabled(false);
                ePassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            final String check = ePassword.getText().toString().trim();

                            if(check.isEmpty()){
                                til.setErrorEnabled(true);
                                til.setError("Please enter Password.");


                            }else if(!chkpwd(check)){
                                til.setErrorEnabled(true);
                                til.setError("Please enter Password minimum 8 Character");

                            } else {
                                til.setErrorEnabled(false);
                                til.setError(null);
                            }

                        }
                    }
                });

            }else {

                ePassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {

                            String check = ePassword.getText().toString().trim();

                            if(check.isEmpty()) {
                                ePassword.setError("Please enter Password");
                            }else if(!chkpwd(ePassword.getText().toString())){
                                ePassword.setError("Please enter Password minimum 8 Character");
                            }else {
                                ePassword.setError(null);
                            }
                        }
                    }
                });
            }

        }else{
            throw new NullPointerException("Validator : Field is null");
        }



    }







    public boolean chkpwd(String sPassword) {

       if(sPassword.length() <6){
            return false;
        }

       return true;
    }

}
