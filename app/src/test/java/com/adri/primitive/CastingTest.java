package com.adri.primitive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CastingTest {
    @Test
    void testCastIntDouble() {
        double doubleAWithDecimals = 2345.2342;
        int doubleAWithDecimalsAsInt = (int) doubleAWithDecimals;
        double doubleBWithoutDecimals = 1234;
        int doubleBWithoutDecimalsAsInt = (int) doubleBWithoutDecimals;


        assertEquals(2345, doubleAWithDecimalsAsInt);
        assertNotEquals(doubleAWithDecimals, (double) doubleAWithDecimalsAsInt);

        assertEquals(1234, doubleBWithoutDecimalsAsInt);
        assertEquals(doubleBWithoutDecimals, (double) doubleBWithoutDecimalsAsInt);
    }
}
