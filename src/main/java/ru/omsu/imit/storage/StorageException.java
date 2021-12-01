package ru.omsu.imit.storage;

public class StorageException extends Exception {
    public StorageException(String s) {
        super(s);
    }

    public StorageException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
