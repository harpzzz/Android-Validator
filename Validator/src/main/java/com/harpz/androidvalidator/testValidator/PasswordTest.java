package com.harpz.androidvalidator.testValidator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class PasswordTest {



    public boolean checkValid(final EditText ePassword, final String message, final TextInputLayout til){

        if(ePassword != null) {
            final String check = ePassword.getText().toString().trim();

            if(til != null) {

                til.setErrorEnabled(false);


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




            }else {
                            if(check.isEmpty()) {
                                ePassword.setError("Please enter Password");
                            }else if(!chkpwd(ePassword.getText().toString())){
                                ePassword.setError("Please enter Password minimum 8 Character");
                            }else {
                                ePassword.setError(null);
                            }
            }

            return chkpwd(ePassword.getText().toString());

        }else{
            throw new NullPointerException("Validator : Field is null");
        }



    }







    public boolean chkpwd(String sPassword) {

       if(sPassword.length() > 7){
            return true;
        }

       return false;
    }

}
