package com.sbt.lesson5.classes;

import com.sbt.lesson5.exeptionClasses.FailedConnectionException;
import com.sbt.lesson5.exeptionClasses.NotEnoughMoneyException;
import com.sbt.lesson5.interfaces.TerminalServer;

import java.util.Random;

public class TerminalServerImpl implements TerminalServer {

    private int balance;

    public TerminalServerImpl(int balance) {
        this.balance = balance;
    }

    @Override
    public int checkedBalance() throws FailedConnectionException {
        if (2 == (new Random().nextInt() % 10)) {    // генерируем случайный обрыв связи
            throw new FailedConnectionException();
        }
        return balance;
    }

    @Override
    public void getMoney(int value) throws FailedConnectionException, NotEnoughMoneyException {
        if (2 == (new Random().nextInt() % 10)) {    // генерируем случайный обрыв связи
            throw new FailedConnectionException();
        }
        if (balance < value) {
            throw new NotEnoughMoneyException();
        } else {
            balance -= value;
        }
    }

    @Override
    public void setMoney(int value) throws FailedConnectionException {
        if (2 == (new Random().nextInt() % 10)) {    // генерируем случайный обрыв связи
            throw new FailedConnectionException();
        }
        balance += value;
    }
}
