package com.sbt.lesson5.classes;

import com.sbt.lesson5.exeptionClasses.FailedConnectionExeption;
import com.sbt.lesson5.exeptionClasses.InvalidSumExeption;
import com.sbt.lesson5.exeptionClasses.NotEnoughMoneyExeption;
import com.sbt.lesson5.interfaces.TerminalServer;

public class TerminalServerImpl implements TerminalServer {

    @Override
    public int checkedBalance() throws FailedConnectionExeption {
        return 0;
    }

    @Override
    public boolean getMoney(int value) throws FailedConnectionExeption, NotEnoughMoneyExeption, InvalidSumExeption {
        return true;
    }

    @Override
    public boolean setMoney(int value) throws FailedConnectionExeption, InvalidSumExeption {
        return true;
    }
}
