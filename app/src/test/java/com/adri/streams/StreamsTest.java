
package com.adri.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamsTest {

    @Test
    void bitSetAsStream() {
        var bitSet = new BitSet();
        bitSet.set(0);

        var foo = Arrays.stream(
                bitSet.toLongArray()
        );

        bitSet.set(3);

        assertArrayEquals(new long[]{1}, foo.toArray());
    }

    @Test
    void mutatedListAsStream() {
        var foo = new ArrayList<>(List.of(1, 2, 3));
        var fooStream = foo.stream();
        foo.add(4);
        assertEquals(List.of(1, 2, 3, 4), fooStream.collect(Collectors.toList()));
    }

    @Test
    void listWithRemovedElementAfterStreamIsCreated() {
        var foo = new ArrayList<>(List.of(1, 2, 3));
        var fooStream = foo.stream();
        foo.remove(0);
        assertEquals(List.of(2, 3), fooStream.collect(Collectors.toList()));
    }
}
