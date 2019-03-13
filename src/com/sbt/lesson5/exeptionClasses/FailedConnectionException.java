package com.sbt.lesson5.exeptionClasses;

public class FailedConnectionException extends Throwable {
    public FailedConnectionException() {
        super();
    }

    public FailedConnectionException(String message) {
        super(message);
    }
}
