package org.example;

import org.junit.jupiter.api.*;

public class TestTest {

    @BeforeAll
    static void initAll(){
        System.out.println("Al principio de todo");
    }

    @Test
    void test(){
        System.out.println("Test");
    }

    @BeforeEach
    void init(){
         System.out.println("Antes de cada test");
     }

    @AfterEach
    void tearDown(){
        System.out.println("Después de cada test");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("Después de todos los test");
    }

}
