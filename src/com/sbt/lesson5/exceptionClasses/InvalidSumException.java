package com.sbt.lesson5.exceptionClasses;

public class InvalidSumException extends Throwable {

    public InvalidSumException() {
        super();
    }

    public InvalidSumException(String message) {
        super(message);
    }
}
