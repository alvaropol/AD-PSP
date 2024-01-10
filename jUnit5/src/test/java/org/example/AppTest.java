package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    HashSet<Integer> hs = new HashSet<>();
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void test(){
        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));

        Collection<Integer> c = Collections.emptyList();

        assertFalse(hs.removeAll(c));
    }

    @ParameterizedTest
    @MethodSource("generateCollectionWithElements")
    void parameterizedTest(List<Integer> hashset, List<Integer> c, boolean expectedResult, int sizeResult){

        hs.addAll(hashset);
        assertEquals(expectedResult,hs.removeAll(c));
        assertEquals(sizeResult,hs.size());
    }

    static Stream<Arguments> generateCollectionWithElements(){
        return Stream.of(
                Arguments.arguments(List.of(1,2,3,4),List.of(1,2,3,5,6,7,8),true,1),
                Arguments.arguments(List.of(1,2,3,5,6,7,8),List.of(1,2,3,4),true,4),
                Arguments.arguments(List.of(),List.of(1),false,0),
                Arguments.arguments(List.of(1,2,3,4),List.of(),false,4)
        );
    }

}
