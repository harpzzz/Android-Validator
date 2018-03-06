package com.harpz.androidvalidator.testValidator;

import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by harpreet on 6/3/18.
 */

public class RadioGroupTest {

    public boolean checkRadio(final RadioGroup radioGroup){


        if(radioGroup != null){

            if(radioGroup.getCheckedRadioButtonId() != 0)
                return true;
            else
                return false;

        }


        return false;

    }

}
