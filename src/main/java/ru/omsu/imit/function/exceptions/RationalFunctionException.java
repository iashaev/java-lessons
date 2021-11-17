package ru.omsu.imit.function.exceptions;

public class RationalFunctionException extends Exception {
    public RationalFunctionException(String s) {
        super(s);
    }

    public RationalFunctionException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
