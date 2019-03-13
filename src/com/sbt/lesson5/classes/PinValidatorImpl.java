package com.sbt.lesson5.classes;

import com.sbt.lesson5.exceptionClasses.AccountIsLockedException;
import com.sbt.lesson5.exceptionClasses.InvalidPinException;
import com.sbt.lesson5.interfaces.PinValidator;

import java.util.Date;

public class PinValidatorImpl implements PinValidator {
    private static final int MAX_COUNT_TO_GO = 3;
    private static final int PENALTY_SEC = 5;

    private String pin;
    private boolean locked;
    private int countToGo;
    private Date lastDateInvalidToGO;

    public PinValidatorImpl(String pin) {
        this.pin = pin;
        this.locked = false;
        this.countToGo = 0;
    }

    @Override
    public boolean pinValidate(String pin) throws InvalidPinException, AccountIsLockedException {
        int timeRemaining;
        if (locked && ((new Date().getTime() - lastDateInvalidToGO.getTime()) / 1000) <= PENALTY_SEC) {
            timeRemaining = PENALTY_SEC - (int) ((new Date().getTime() - lastDateInvalidToGO.getTime()) / 1000);
            throw new AccountIsLockedException("Error: Your card is locked for seconds ", timeRemaining);
        }

        if (pin.equals(this.pin)) {
            countToGo = 0;
            locked = false;
            return true;
        } else {
            countToGo++;
            lastDateInvalidToGO = new Date();
            if (countToGo >= MAX_COUNT_TO_GO) {
                locked = true;
                timeRemaining = PENALTY_SEC - (int) ((new Date().getTime() - lastDateInvalidToGO.getTime()) / 1000);
                throw new AccountIsLockedException("Error: Your card is locked for seconds ", timeRemaining);
            }
            int remainingAttemps = MAX_COUNT_TO_GO - countToGo;
            if (remainingAttemps < 0) remainingAttemps = 0;
            throw new InvalidPinException("Error: Invalid PIN code. Remaining attempts: ",remainingAttemps);
        }
    }
}
