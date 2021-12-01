package ru.omsu.imit.storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class StorageTest {
    @Test(expected = StorageException.class)
    public void testCreateFail() throws Exception {
        new Storage<String>(-1);
    }

    @Test
    public void testAddItemSuccess() throws Exception {
        IStorage<String> storage = new Storage<String>(3);
        storage.add("qwe");
        assertEquals(1, storage.getCount());
        assertEquals("qwe", ((Storage<String>) storage).getList().get(0));
    }

    @Test(expected = StorageException.class)
    public void testAddItemOverflow() throws Exception {
        IStorage<String> storage = new Storage<String>(3);
        storage.add("qwe");
        storage.add("rty");
        storage.add("zxc");
        storage.add("fail");
    }

    @Test
    public void testRemoveItemSuccess() throws Exception {
        IStorage<String> storage = new Storage<>(2);
        storage.add("qwe");
        storage.remove("qwe");
        assertEquals(0, storage.getCount());
    }

    @Test
    public void testRemoveItemNoItem() throws Exception {
        IStorage<String> storage = new Storage<>(2);
        storage.add("qwe");
        storage.remove("asd");
        assertEquals(1, storage.getCount());
        assertEquals("qwe", ((Storage) storage).getList().get(0));
    }
}