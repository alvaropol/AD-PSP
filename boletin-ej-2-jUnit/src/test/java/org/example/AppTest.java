package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @ParameterizedTest
    @MethodSource("provideTestCases")
     <T> void testItemsContains(T[] items, T value, int size, boolean identity, boolean expectedResult) {
        Items<T> newItems = new Items<>(items, size);
        assertEquals(expectedResult, newItems.contains(value, identity));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new Integer[]{3,3,2,5,6,2}, 6, true, true),
                Arguments.of(new String[]{"3", "2", "8", "23", "64"}, "3", 5, true, true),
                Arguments.of(new String[]{"3", "2"}, null, 2, true, true)
        );
    }
}
