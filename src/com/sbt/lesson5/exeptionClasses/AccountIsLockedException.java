package com.sbt.lesson5.exeptionClasses;

public class AccountIsLockedException extends Throwable {
    private final int timeRemaining;

    public AccountIsLockedException(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getRemainingSeconds() {
        return timeRemaining;
    }
}
