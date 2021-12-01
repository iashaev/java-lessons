package ru.omsu.imit.storage;

public interface IValuableStorage<T> extends IStorage<T> {
    int getTotalValue();
}

