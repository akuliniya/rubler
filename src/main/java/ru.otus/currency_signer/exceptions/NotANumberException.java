package ru.otus.currency_signer.exceptions;

public class NotANumberException extends Exception{
    String message;
    Throwable cause;

    public NotANumberException(Throwable cause) {
        this.message = "Введено не число";
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public synchronized Throwable getCause() {
        return cause;
    }
}
