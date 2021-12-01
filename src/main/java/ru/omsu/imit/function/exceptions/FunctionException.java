package ru.omsu.imit.function.exceptions;

public class FunctionException extends Exception {
    public FunctionException(String s) {
        super(s);
    }

    public FunctionException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
