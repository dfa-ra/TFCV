package org.example.complex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Complex {
    private double x;
    private double y;

    public static Complex sum(Complex a, Complex b) {
        return new Complex(a.x + b.x, a.y + b.y);
    }

    public static Complex mul(Complex a, Complex b) {
        return new Complex(a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x);
    }

    public static double mod(Complex a) {
        return Math.sqrt(a.x * a.x + a.y * a.y);
    }

}
