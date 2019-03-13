package com.sbt.lesson5.exeptionClasses;

public class NotEnoughMoneyException extends Throwable {
    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
