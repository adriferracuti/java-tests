package com.adri.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CloseableTest {

    @Test
    void closeAfterReturn() throws Exception {
        try (var foo = new Foo()) {
            return;
        }
    }

    @Test
    void exceptionThrown()  {
        Assertions.assertThrows(Exception.class, () -> {
            try (var foo = new Foo()) {
                foo.exception();
                return;
            }
        });
    }

    private static class Foo implements AutoCloseable {

        public void exception() throws Exception {
            throw new Exception("alarm");
        }
        @Override
        public void close() throws Exception {
            System.out.println("Closed");
        }
    }
}
