package com.harpz.androidvalidator.Validation.testValidation;

import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class NameTest {

    String namepattern = "[a-zA-Z ]+";


    public void checkValid(final EditText eName){

        if(eName != null) {

            eName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus){
                        final String check = eName.getText().toString().trim();

                        if (!namevalidation(check)) {
                            eName.setError("Please enter valid Name.");
                            eName.requestFocus();
                        } else {
                            eName.setError(null);
                            eName.setFocusable(false);
                        }

                    }
                }
            });

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
