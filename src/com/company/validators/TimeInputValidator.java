package com.company.validators;

import com.company.exceptions.RangeValidationException;

public class TimeInputValidator{
    public static void test(int time) throws RangeValidationException {
        if(!(time >= 50 && time <=1000)){
            throw new RangeValidationException("out of range");
        }
    }
}
