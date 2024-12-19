package org.example.lab2;

import org.example.complex.Complex;
import org.example.lab1.fractals.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GraphDrawer extends ImageIcon{

    private final BufferedImage image;

    public GraphDrawer(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        setImage(image);
    }

    public void draw(Fractal name) {

    }

    public void drawMove(Fractal name, double x, double y){

    }

    private void putPixels (int[][] frame)
    {
        for (int y = 0; y < frame.length; y++) {
            for (int x = 0; x < frame[y].length; x++) {
                image.setRGB(x, y, frame[y][x]);
            }
        }
    }
}
