package org.example.lab1.fractals;

import org.example.complex.Complex;

import java.awt.*;

public class Mandelbrot implements IFractal {

    private final int[][] frame;

    private final int width;
    private final int height;

    public Mandelbrot(int w, int h) {
        frame = new int[w][h];
        width = w;
        height = h;
    }

    @Override
    public int[][] getPixelsColor(Complex c) {
        return getPixelsColor();
    }

    @Override
    public int[][] getPixelsColor()
    {
        double X0 = -2, X1 = 2, Y0 = -2, Y1 = 2;

        Complex z;
        for (int ys = 0; ys < height; ys++) {
            for (int xs = 0; xs < width; xs++) {
                z = new Complex(xs * (X1 - X0) / width + X0, ys * (Y1 - Y0) / height + Y0);
                int n = fMandelbrot(z);
                frame[ys][xs] = new Color(n % 255, n * n % 255, 0 % 255).getRGB();
            }
        }
        return frame;
    }

    private int fMandelbrot(Complex c)
    {
        Complex z = new Complex(0, 0);

        for (int n = 0; n < 255; n++)
        {
            z = c.sum(z.mul(z));
            if (z.mod() >= 2) {
                return n;
            }
        }

        return 0;
    }

}
