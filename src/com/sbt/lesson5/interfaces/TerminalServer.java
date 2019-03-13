package com.sbt.lesson5.interfaces;

import com.sbt.lesson5.exeptionClasses.FailedConnectionException;
import com.sbt.lesson5.exeptionClasses.NotEnoughMoneyException;

public interface TerminalServer {
    int checkedBalance() throws FailedConnectionException;

    void getMoney(int value) throws FailedConnectionException, NotEnoughMoneyException;

    void setMoney(int value) throws FailedConnectionException;
}
