package ru.omsu.imit.storage;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> implements IStorage<T> {
    private List<T> list;
    private int maxSize;

    public Storage(int maxSize) throws StorageException {
        if (maxSize <= 0) {
            throw new StorageException("Size must be positive");
        }
        list = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    protected List<T> getList() { return list; }

    @Override
    public void add(T item) throws StorageException {
        if (list.size() >= maxSize) {
            throw new StorageException("Storage overflow");
        }
        list.add(item);
    }

    @Override
    public void remove(T item) {
        list.remove(item);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
