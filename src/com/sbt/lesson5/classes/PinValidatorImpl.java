package com.sbt.lesson5.classes;

import com.sbt.lesson5.exeptionClasses.AccountIsLockedException;
import com.sbt.lesson5.exeptionClasses.InvalidPinExeption;
import com.sbt.lesson5.interfaces.PinValidator;

public class PinValidatorImpl implements PinValidator {
    @Override
    public boolean pinValidate(int pin) throws InvalidPinExeption, AccountIsLockedException {
        return false;
    }
}
