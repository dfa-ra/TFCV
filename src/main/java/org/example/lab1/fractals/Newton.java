package org.example.lab1.fractals;

import org.example.complex.Complex;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Newton implements IFractal{

    private final int[][] frame;

    private final int width;
    private final int height;
    private final double scale;
    private final int pow;
    private final List<Complex> roots;
    private final List<Color> colors;

    public Newton(int w, int h, double scale, int pow) {
        frame = new int[w][h];
        width = w;
        height = h;
        this.scale = scale;

        this.pow = pow;

        this.roots = new ArrayList<>();
        this.colors = new ArrayList<>();
        for (int i = 0; i < pow; ++i) {
            double phi = 2 * Math.PI * i / pow;
            roots.add(new Complex(Math.cos(phi), Math.sin(phi)));
            colors.add(Color.getHSBColor((float) phi, 0.7F, 0.8F));
        }
    }

    @Override
    public int[][] getPixelsColor(Complex c) {
        return getPixelsColor();
    }

    public int[][] getPixelsColor()
    {
        double X0 = -scale, X1 = scale, Y0 = -scale, Y1 = scale;

        Complex z;
        for (int ys = 0; ys < height; ys++) {
            for (int xs = 0; xs < width; xs++) {
                z = new Complex(xs * (X1 - X0) / width + X0, ys * (Y1 - Y0) / height + Y0);
                Color c = fNewton(z);
                frame[ys][xs] = c.getRGB();
            }
        }
        return frame;
    }

    private Complex function(Complex z) {
        return z.pow(pow).sum(Complex.valueOf(-1));
    }

    private Complex derivative(Complex z) {
        return Complex.valueOf(pow).mul(z.pow(pow - 1));
    }

    private Color fNewton(Complex z) {
        double threshold = 0.000000001;

        for (int n = 0; n <= 1000; ++n) {
            z = z.sum(function(z).div(derivative(z)).neg());

            for (int i = 0; i < roots.size(); i++) {
                if (z.sum(roots.get(i).neg()).mod() < threshold) {
                    return colors.get(i);
                }
            }
        }
        return Color.BLACK;
    }
}
