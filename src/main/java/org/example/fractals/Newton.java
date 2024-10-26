package org.example.fractals;

import org.example.complex.Complex;

import java.awt.*;

public class Newton implements IFractal{

    private final int[][] frame;

    private final int width;
    private final int height;

    public Newton(int w, int h) {
        frame = new int[w][h];
        width = w;
        height = h;
    }

    @Override
    public int[][] getPixelsColor()
    {
        double X0 = -1, X1 = 1, Y0 = -1, Y1 = 1;

        Complex z;
        for (int ys = 0; ys < height; ys++) {
            for (int xs = 0; xs < width; xs++) {
                z = new Complex(xs * (X1 - X0) / width + X0, ys * (Y1 - Y0) / height + Y0);
                int n = fNewton(z);
                frame[ys][xs] = new Color(n % 255, n * n % 255, 0 % 255).getRGB();
            }
        }
        return frame;
    }

    private Complex function(Complex z) {
        return Complex.valueOf(-1).sum(z.mul(z).mul(z));
    }

    private Complex derivative(Complex z) {
        return Complex.valueOf(3).mul(z.mul(z));
    }

    private int fNewton(Complex z) {
        double threshold =  0.00000000001;
        Complex[] roots = {
                new Complex(1, 0),
                new Complex(-0.5, Math.sqrt(3)/2),
                new Complex(-0.5, -Math.sqrt(3)/2)
        };

        int n = 0;
        boolean brFlag = false;
        while (n < 255 && !brFlag) {
            z = z.sum(function(z).div(derivative(z)).neg());

            for (var root : roots) {
                if (z.sum(root.neg()).mod() < threshold) {
                    brFlag = true;
                    break;
                }
            }
            n++;
        }
        return n;
    }
}
