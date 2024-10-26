package org.example;

import org.example.fractals.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class FractalDrawer extends ImageIcon{

    private final BufferedImage image;
    private final HashMap<Fractal, IFractal> fractals;

    public FractalDrawer(int width, int height) {
        fractals = new HashMap<>(){{
            put(Fractal.MANDELBROT, new Mandelbrot(width, height));
            put(Fractal.JULIA, new Julia(width, height));
            put(Fractal.NEWTON, new Newton(width, height));
        }};
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        setImage(image);
    }

    public void draw(Fractal name) {
        putPixels(fractals.get(name).getPixelsColor());
    }

    private void putPixels ( int[][] frame)
    {
        for (int y = 0; y < frame.length; y++) {
            for (int x = 0; x < frame[y].length; x++) {
                image.setRGB(x, y, frame[y][x]);
            }
        }
    }
}
