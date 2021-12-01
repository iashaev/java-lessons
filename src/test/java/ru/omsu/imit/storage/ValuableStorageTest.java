package ru.omsu.imit.storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValuableStorageTest {
    private class Diamond implements IThingWithValue {
        @Override
        public int getValue() {
            return 100500;
        }
    }

    @Test
    public void testGetTotalValue() throws Exception {
        IValuableStorage<Diamond> storage = new ValuableStorage<>(3);
        storage.add(new Diamond());
        storage.add(new Diamond());
        assertEquals(2 * 100500, storage.getTotalValue());
    }
}