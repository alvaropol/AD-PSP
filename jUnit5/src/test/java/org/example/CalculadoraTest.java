package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    @DisplayName("1+1=2")
    void sumarDosNumeros(){
        Calculadora c= new Calculadora();
        int expected= 2;

        assertEquals(expected,c.sumar(1,1));
    }
}
