package com.sbt.lesson5.interfaces;

import com.sbt.lesson5.exceptionClasses.AccountIsLockedException;
import com.sbt.lesson5.exceptionClasses.InvalidPinException;

public interface PinValidator {
    boolean pinValidate(String pin) throws InvalidPinException, AccountIsLockedException;
}
