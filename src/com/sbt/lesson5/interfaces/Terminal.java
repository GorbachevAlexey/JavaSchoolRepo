package com.sbt.lesson5.interfaces;

import com.sbt.lesson5.exceptionClasses.*;

public interface Terminal {
    int checkBalance() throws NotValidatePinException, FailedConnectionException;

    void setMoney(int value) throws NotValidatePinException, InvalidSumException, FailedConnectionException;

    void getMoney(int value) throws NotValidatePinException, InvalidSumException, NotEnoughMoneyException, FailedConnectionException;

    void validatePin(String pin) throws InvalidPinException, AccountIsLockedException;

    boolean isPinValidated();
}
