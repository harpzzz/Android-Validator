package com.harpz.androidvalidator;

/**
 * Created by Neha Thakur on 9/11/2017.
 */

import java.util.ArrayList;

public interface ValidatorListener {


    public void onValidateSuccess();

    public void onValidateFailed(ArrayList list);
}
