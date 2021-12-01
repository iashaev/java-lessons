package ru.omsu.imit.storage;

public class ValuableStorage<T extends IThingWithValue> extends Storage<T> implements IValuableStorage<T> {
    public ValuableStorage(int maxSize) throws StorageException {
        super(maxSize);
    }

    @Override
    public int getTotalValue() {
        int totalValue = 0;
        for (T item: getList()) {
            totalValue += item.getValue();
        }
        return totalValue;
    }
}
