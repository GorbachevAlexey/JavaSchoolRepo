package com.sbt.lesson5.interfaces;

import com.sbt.lesson5.exeptionClasses.AccountIsLockedException;
import com.sbt.lesson5.exeptionClasses.InvalidPinException;

public interface PinValidator {
    boolean pinValidate(String pin) throws InvalidPinException, AccountIsLockedException;
}
