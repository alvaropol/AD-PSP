package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    void test(){
        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));

        Collection<Integer> c = Collections.emptyList();

        assertFalse(hs.removeAll(c));
        //assertEquals();
    }
}
