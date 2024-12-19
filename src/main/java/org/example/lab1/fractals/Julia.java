package org.example.lab1.fractals;

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
    public int[][] getPixelsColor(Complex c){
        Complex z;

        double X0 = -1.2, X1 = 1.2, Y0 = -1.2, Y1 = 1.2;
        for (int ys = 0; ys < height; ys++) {
            for (int xs = 0; xs < width; xs++) {
                z = new Complex(xs * (X1 - X0) / width + X0, ys * (Y1 - Y0) / height + Y0);
                int n = fJulia(z, c);
                frame[xs][ys] = new Color(n % 255, n % 255, 0 % 255).getRGB();
            }
        }
        return frame;
    }

    public int[][] getPixelsColor(){
        return getPixelsColor(new Complex(-0.5251993, 0.5251993));
    }

    private int fJulia (Complex z, Complex c)
    {
        for (int n = 0; n < 255; ++n) {
            z = c.sum(z.pow(2));
            if (z.mod() >= 2) {
                return n * 5;
            }
        }

        return 0;
    }

}
