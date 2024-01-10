package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @ParameterizedTest
    @MethodSource("generateTriangles")
    void parameterizedTest(int a, int b, int c, TipoTriangulo expectecType){

    assertEquals(expectecType, Triangle.typeTriangle(a,b,c));
    }

    static Stream<Arguments> generateTriangles(){
        return Stream.of(
                Arguments.arguments(3, 3, 3, TipoTriangulo.EQUILATERO),
                Arguments.arguments(1, 2, 2, TipoTriangulo.ISOSCELES),
                Arguments.arguments(2, 1, 2, TipoTriangulo.ISOSCELES),
                Arguments.arguments(2, 2, 1, TipoTriangulo.ISOSCELES),
                Arguments.arguments(3, 2, 4, TipoTriangulo.ESCALENO),
                Arguments.arguments(0, 3, 6, TipoTriangulo.NOESUNTRIANGULO),
                Arguments.arguments(6, 0, 4, TipoTriangulo.NOESUNTRIANGULO),
                Arguments.arguments(2, 3, 0, TipoTriangulo.NOESUNTRIANGULO),
                Arguments.arguments(-4, -23, -6, TipoTriangulo.NOESUNTRIANGULO),
                Arguments.arguments(-12, 2, 4, TipoTriangulo.NOESUNTRIANGULO),
                Arguments.arguments(6, -4, 12, TipoTriangulo.NOESUNTRIANGULO),
                Arguments.arguments(2, 2, -4, TipoTriangulo.NOESUNTRIANGULO)
        );
    }
}
