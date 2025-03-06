package com.idforideas.bancosaintpatrick.exception;

public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException(String message) {
        super(message);
    }

}
