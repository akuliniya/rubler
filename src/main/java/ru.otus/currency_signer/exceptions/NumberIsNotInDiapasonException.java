package ru.otus.currency_signer.exceptions;

public class NumberIsNotInDiapasonException extends Exception{
    String message;
    Throwable cause;

    public NumberIsNotInDiapasonException(Throwable cause) {
        this.message = "Введенное число выходит за границы требуемого диапазона";
        this.cause = cause;
    }

    public NumberIsNotInDiapasonException() {
        this.message = "Введенное число выходит за границы требуемого диапазона";
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
