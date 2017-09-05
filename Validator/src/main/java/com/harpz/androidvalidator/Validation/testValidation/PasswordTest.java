package com.harpz.androidvalidator.Validation.testValidation;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class PasswordTest {



    public void checkValid(final EditText ePassword){
        if(ePassword != null) {

            ePassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus){
                              chkpwd(ePassword);
                      }
                }
            });

        }



    }






    public boolean chkpwd(EditText ePassword) {

        if(ePassword.getText().length() == 0){

            ePassword.setError("Please enter Password");
            ePassword.requestFocus();
            return false;
        }else if(ePassword.length() <6){

            ePassword.setError("Please enter Password minimum 8 Character");
            ePassword.requestFocus();
            return false;
        }

        ePassword.setError(null);
        ePassword.setFocusable(false);
       return true;
    }

}
