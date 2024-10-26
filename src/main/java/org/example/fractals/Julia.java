package org.example.fractals;

import org.example.complex.Complex;

import java.awt.*;

public class Julia implements IFractal{

    private final int[][] frame;
    private final int width;
    private final int height;

    public Julia(int w, int h) {
        frame = new int[w][h];
        width = w;
        height = h;
    }

    @Override
    public int[][] getPixelsColor(){
        Complex z;

        double X0 = -2, X1 = 2, Y0 = -2, Y1 = 2;
        for (int ys = 0; ys < height; ys++) {
            for (int xs = 0; xs < width; xs++) {
                z = new Complex(xs * (X1 - X0) / width + X0, ys * (Y1 - Y0) / height + Y0);
                int n = fJulia(z, new Complex(-0.7, 0.7));
                frame[xs][ys] = new Color(n % 255, n * n % 255, 0 % 255).getRGB();
            }
        }
        return frame;
    }

    private int fJulia (Complex z, Complex c)
    {
        int n = 0;
        while (n < 255 && Complex.mod(z) < 2)
        {
            z = Complex.sum(c, Complex.mul(z, z));
            n++;
        }

        return n;
    }

}
