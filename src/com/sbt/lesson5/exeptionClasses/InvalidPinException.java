package com.sbt.lesson5.exeptionClasses;

public class InvalidPinException extends Throwable {
    private int remainingCountToGO;
    private String detailMessage;

    public InvalidPinException() {
    }

    public InvalidPinException(String message, int remainingCountToGO) {
        this.remainingCountToGO = remainingCountToGO;
        this.detailMessage = message;
    }

    public int getRemainingAttempts() {
        return remainingCountToGO;
    }

    @Override
    public String getMessage() {
        return detailMessage;
    }
}
