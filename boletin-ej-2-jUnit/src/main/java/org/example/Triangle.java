package org.example;

public class Triangle {

    public static TipoTriangulo typeTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return TipoTriangulo.NOESUNTRIANGULO;

        if (a == b && b == c)
            return TipoTriangulo.EQUILATERO;
        else if (a == b || b == c || a == c)
            return TipoTriangulo.ISOSCELES;
        else if (a + b > c && b + c > a && a + c > b)
            return TipoTriangulo.ESCALENO;
        else
            return TipoTriangulo.NOESUNTRIANGULO;
    }
}
