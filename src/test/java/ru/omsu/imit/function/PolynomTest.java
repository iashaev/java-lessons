package ru.omsu.imit.function;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomTest {
    @Test
    public void testDerive() {
        Polynom polynom = new Polynom(1, 2, 3);  // 1 + 2x + 3x^2
        Polynom expected = new Polynom(2, 6);   // 2 + 6x
        assertEquals(expected, polynom.derive());
    }

    @Test
    public void testDeriveConstPolynom() {
        Polynom polynom = new Polynom(1);  // 1
        Polynom expected = new Polynom(0);   // 2 + 6x
        assertEquals(expected, polynom.derive());
    }

    @Test
    public void testDeriveZeroPolynom() {
        Polynom polynom = new Polynom(0);  // 1
        Polynom expected = new Polynom(0);   // 2 + 6x
        assertEquals(expected, polynom.derive());
    }
}