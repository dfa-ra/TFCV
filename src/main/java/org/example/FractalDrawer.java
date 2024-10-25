package org.example;

import org.example.fractals.IFractal;
import org.example.fractals.Julia;
import org.example.fractals.Mandelbrot;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class FractalDrawer extends ImageIcon{

    private final BufferedImage image = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final HashMap<String, IFractal> fractals = new HashMap<>(){{
        put("Mandelbrot", new Mandelbrot(Main.WIDTH, Main.HEIGHT));
        put("Julia", new Julia(Main.WIDTH, Main.HEIGHT));
    }};

    public FractalDrawer() {
        putPixels(fractals.get("Mandelbrot").getPixelsColor());
        setImage(image);
    }

    private void putPixels ( int[][] frame)
    {
        for (int y = 0; y < frame.length; y++)
            for (int x = 0; x < frame[y].length; x++)
                image.setRGB(x, y, frame[y][x]);
    }
}
