package com.sbt.lesson5.exeptionClasses;

public class NotValidatePinException extends Throwable {
    public NotValidatePinException() {
        super();
    }

    public NotValidatePinException(String message) {
        super(message);
    }
}
