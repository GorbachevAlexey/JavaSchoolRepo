package com.sbt.lesson5.classes;

import com.sbt.lesson5.exeptionClasses.*;
import com.sbt.lesson5.interfaces.PinValidator;
import com.sbt.lesson5.interfaces.Terminal;
import com.sbt.lesson5.interfaces.TerminalServer;

public class TerminalImpl implements Terminal {
    private final TerminalServer terminalServer;
    private final PinValidator pinValidator;
    private boolean pinValidated;

    public TerminalImpl(TerminalServer terminalServer, PinValidator pinValidator) {
        this.terminalServer = terminalServer;
        this.pinValidator = pinValidator;
        this.pinValidated = false;
    }

    @Override
    public int checkBalance() throws NotValidatePinException, FailedConnectionException {
        if (!pinValidated) {
            throw new NotValidatePinException();
        }
        return terminalServer.checkedBalance();
    }

    @Override
    public void setMoney(int value) throws NotValidatePinException, InvalidSumException, FailedConnectionException {
        if (!pinValidated) {
            throw new NotValidatePinException();
        } else if ((0 != value % 100) || (value <= 0)) {
            throw new InvalidSumException();
        } else {
            terminalServer.setMoney(value);
        }
    }

    @Override
    public void getMoney(int value) throws NotValidatePinException, InvalidSumException, NotEnoughMoneyException, FailedConnectionException {
        if (!pinValidated) {
            throw new NotValidatePinException();
        } else if ((0 != value % 100) || (value <= 0)) {
            throw new InvalidSumException();
        } else {
            terminalServer.getMoney(value);
        }
    }

    @Override
    public void validatePin(String pin) throws InvalidPinException, AccountIsLockedException {
        pinValidator.pinValidate(pin);
        pinValidated = true;
    }

    @Override
    public boolean isPinValidated() {
        return pinValidated;
    }
}
