package com.sbt.lesson5.exceptionClasses;

public class NotValidatePinException extends Throwable {
    public NotValidatePinException() {
        super();
    }

    public NotValidatePinException(String message) {
        super(message);
    }
}
