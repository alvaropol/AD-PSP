package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetTest {

    List<Integer> c;
    HashSet<Integer> hs;

    @BeforeEach
    void setup(){
        hs= new HashSet<>();
        c= new ArrayList<>();
    }

    @Test
    void hashSetSizeLessThanCollectionSize(){
        hs.addAll(List.of(1,2,3,4,5));
        c.addAll(List.of(1,2,3,5,6,7,8,9));

        //True
        boolean actual = hs.removeAll(c);
        assertTrue(actual);
        assertEquals(1, hs.size());
        assertTrue(hs.contains(4));

    }

    @Test
    void hashSetSizeGreaterThanCollectionSize(){
        c.addAll(List.of(1,2,3,4,5));
        hs.addAll(List.of(1,2,3,5,6,7,8,9));

        //True
        boolean actual = hs.removeAll(c);
        assertTrue(actual);
        assertEquals(4, hs.size());

    }

    @AfterEach
    void tearDown(){
        hs= null;
        c= null;
    }
}

