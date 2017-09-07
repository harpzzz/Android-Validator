package com.harpz.androidvalidator.Validation.testValidation;

import android.util.Log;
import android.widget.CheckBox;



public class CheckedBoxTest {
    public void checkValid(CheckBox checkBox,String message) {


        if(checkBox != null){

            if(!checkBox.isChecked()){

                Log.i("checkbox",message);
              }

        }else{
            throw new NullPointerException("Validator : Field is null");

        }


    }
}
