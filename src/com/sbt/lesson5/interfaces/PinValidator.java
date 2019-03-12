package com.sbt.lesson5.interfaces;

import com.sbt.lesson5.exeptionClasses.AccountIsLockedException;
import com.sbt.lesson5.exeptionClasses.InvalidPinExeption;

public interface PinValidator {
    boolean pinValidate(int pin) throws InvalidPinExeption, AccountIsLockedException;
}
