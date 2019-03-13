package com.sbt.lesson5.exceptionClasses;

public class FailedConnectionException extends Throwable {
    public FailedConnectionException() {
        super();
    }

    public FailedConnectionException(String message) {
        super(message);
    }
}
