package ru.omsu.imit.string_services;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringArrayServiceTest {
    @Test
    public void testCountWordsByFirstChar() {
        String[] src = { "aaa", "bbb", "abc" };
        assertEquals(2, StringArrayService.getCountWordsByFirstChar(src, 'a'));
    }

    @Test
    public void testCountWordsByFirstCharWithEmptyStrings() {
        String[] src = { "aaa", "bbb", "", "abc" };
        assertEquals(2, StringArrayService.getCountWordsByFirstChar(src, 'a'));
    }

    @Test
    public void testAddLineNmbers() {
        String[] src = { "aaa", "", "bbb" };
        String[] expected = { "1. aaa", "2. ", "3. bbb" };
        assertArrayEquals(expected, StringArrayService.addLineNumbers(src));
    }
}