package com.sbt.lesson5.classes;

import com.sbt.lesson5.exceptionClasses.FailedConnectionException;
import com.sbt.lesson5.exceptionClasses.NotEnoughMoneyException;
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
            throw new FailedConnectionException("Error: Connection is lost, try later");
        }
        return balance;
    }

    @Override
    public void getMoney(int value) throws FailedConnectionException, NotEnoughMoneyException {
        if (2 == (new Random().nextInt() % 10)) {    // генерируем случайный обрыв связи
            throw new FailedConnectionException("Error: Connection is lost, try later");
        }
        if (balance < value) {
            throw new NotEnoughMoneyException("Error: You have not enough money.");
        } else {
            balance -= value;
        }
    }

    @Override
    public void setMoney(int value) throws FailedConnectionException {
        if (2 == (new Random().nextInt() % 10)) {    // генерируем случайный обрыв связи
            throw new FailedConnectionException("Error: Connection is lost, try later");
        }
        balance += value;
    }
}
