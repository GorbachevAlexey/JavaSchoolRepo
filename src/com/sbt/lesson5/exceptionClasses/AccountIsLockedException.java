package com.sbt.lesson5.exceptionClasses;

public class AccountIsLockedException extends Throwable {
    private int timeRemaining;
    private String detailMessage;

    public AccountIsLockedException(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public AccountIsLockedException(String message, int timeRemaining) {
        this.timeRemaining = timeRemaining;
        this.detailMessage = message;
    }

    public int getRemainingSeconds() {
        return timeRemaining;
    }

    @Override
    public String getMessage() {
        return detailMessage;
    }
}
