package com.harpz.androidvalidator.testValidator;

import android.util.Log;
import android.widget.CheckBox;



public class CheckedBoxTest {
    public boolean checkValid(CheckBox checkBox) {


        if(checkBox != null){

            if(checkBox.isChecked()){
                return true;
              }

            return false;

        }else{
            throw new NullPointerException("Validator : Field is null");

        }



    }
}
