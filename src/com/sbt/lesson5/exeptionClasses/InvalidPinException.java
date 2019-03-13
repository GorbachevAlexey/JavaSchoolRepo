package com.sbt.lesson5.exeptionClasses;

public class InvalidPinException extends Throwable {
    private int remainingCountToGO;

    public InvalidPinException() {
    }

    public InvalidPinException(int remainingCountToGO) {
        this.remainingCountToGO = remainingCountToGO;
    }

    public int getRemainingAttempts() {
        return remainingCountToGO;
    }
}
