package org.example.lab1.fractals;


import org.example.complex.Complex;

public interface IFractal {
    int[][] getPixelsColor(Complex c);
    int[][] getPixelsColor();
}
