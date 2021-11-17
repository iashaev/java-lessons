package ru.omsu.imit.string_services;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringServiceTest {
    @Test
    public void testDeleteChars() {
        String src = "qwe#rty#yui";
        String expected = "qwertyyui";
        assertEquals(expected, StringService.deleteChars(src, '#'));
    }

    @Test
    public void testDeleteCharsNoCharsToDel() {
        String src = "qwe";
        String expected = "qwe";
        assertEquals(expected, StringService.deleteChars(src, '#'));
    }

    @Test
    public void testDeleteAllChars() {
        String src = "###";
        String expected = "";
        assertEquals(expected, StringService.deleteChars(src, '#'));
    }

    @Test
    public void testDeleteFromEmptyString() {
        String src = "";
        String expected = "";
        assertEquals(expected, StringService.deleteChars(src, '#'));
    }

    @Test
    public void testGetCountWordsOneDelimiter() {
        String src = "qwe rty yui";
        assertEquals(3, StringService.getWordsCount(src));
    }

    @Test
    public void testGetCountWordsManyDelimiters() {
        String src = " qwe  rty  yui ";
        assertEquals(3, StringService.getWordsCount(src));
    }

    @Test
    public void testGetCountWordsNoWords() {
        String src = "  ";
        assertEquals(0, StringService.getWordsCount(src));
    }

    @Test
    public void testSwapWordsOneWord() {
        String src = "qwe";
        String expected = "qwe";
        assertEquals(expected, StringService.swapFirstAndLastWords(src));

    }

    @Test
    public void testSwapWordsNoWord() {
        String src = "   ";
        String expected = "   ";
        assertEquals(expected, StringService.swapFirstAndLastWords(src));
    }

    @Test
    public void testSwapWordsSeveralWords() {
        String src = "qwe rty uio";
        String expected = "uio rty qwe";
        assertEquals(expected, StringService.swapFirstAndLastWords(src));
    }

    @Test
    public void testSwapWordsSeveralWordsSpacesOnEnds() {
        String src = " qwe rty uio  ";
        String expected = " uio rty qwe  ";
        assertEquals(expected, StringService.swapFirstAndLastWords(src));
    }

    @Test
    public void testGetShortNameWithMissleName() {
        String lastName = "Иванов";
        String firstName =  "Сидор";
        String middleName = "Петрович";
        String expected = "С.П. Иванов";
        assertEquals(expected, StringService.getShortName(lastName, firstName, middleName));
    }

    @Test
    public void testGetShortNameWithoutMissleName() {
        String lastName = "Иванов";
        String firstName =  "Сидор";
        String middleName = "";
        String expected = "С. Иванов";
        assertEquals(expected, StringService.getShortName(lastName, firstName, middleName));
    }
}