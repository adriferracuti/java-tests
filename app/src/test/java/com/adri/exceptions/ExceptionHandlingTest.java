package com.adri.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ExceptionHandlingTest {
    @Test
    void inlineExceptionIsCaughtInCatchBlock() {
        try {
            throw new IOException("foo");
        }
        catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

}
