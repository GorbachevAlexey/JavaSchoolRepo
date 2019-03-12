package com.sbt.lesson5.interfaces;

import com.sbt.lesson5.exeptionClasses.FailedConnectionExeption;
import com.sbt.lesson5.exeptionClasses.InvalidSumExeption;
import com.sbt.lesson5.exeptionClasses.NotEnoughMoneyExeption;

public interface TerminalServer {
    int checkedBalance() throws FailedConnectionExeption;
    boolean getMoney(int value) throws FailedConnectionExeption, NotEnoughMoneyExeption, InvalidSumExeption;
    boolean setMoney(int value) throws FailedConnectionExeption, InvalidSumExeption;
}
