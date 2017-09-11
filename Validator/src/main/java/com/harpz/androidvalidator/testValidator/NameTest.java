package com.harpz.androidvalidator.testValidator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Neha Thakur on 9/4/2017.
 */

public class NameTest {

    String namepattern = "[a-zA-Z ]+";


    public boolean checkValid(final EditText eName, final String message, final TextInputLayout til){

        if(eName != null) {
            String check = eName.getText().toString().trim();
            if(til != null) {
                til.setErrorEnabled(false);


                            if (!namevalidation(check)) {
                                til.setErrorEnabled(true);
                                til.setError(message);

                            } else {
                                til.setErrorEnabled(false);
                                til.setError(null);
                            }


            }else{


                            if (!namevalidation(check)) {

                                eName.setError("Please enter valid Name.");
                            } else {
                                eName.setError(null);

                            }

                        }


                        return namevalidation(check);

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
