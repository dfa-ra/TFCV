package org.example.lab2;

import org.example.complex.Complex;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GraphDrawer extends ImageIcon {

    private final BufferedImage image;

    public GraphDrawer(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        setImage(image);
    }

    public void draw() {
        putPixels(getFrame(0));
    }

    public void drawMove(double k) {
        putPixels(getFrame(k));
    }

    private void putPixels(Complex[] frame) {
        clearImage();

        for (Complex point : frame) {
            if (point == null) continue;
            int x = (int) ((point.getX() + 10) * 25);
            int y = (int) ((point.getY() + 10) * 25);

            // Проверка на попадание в границы изображения
            if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
                image.setRGB(x, y, 0xFFFFFF); // Белый цвет для пикселя
            }
        }
    }

    private void clearImage() {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(new Color(0));
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        g2d.dispose();
    }

    private List<Complex> startFunc() {
        double accuracy = 0.01;
        List<Complex> result = new ArrayList<>();
        for (double i = -10; i < 10; i += accuracy) {
            for (double j = -10; j < 0; j += accuracy) {
                Complex z = new Complex(i, j);
                if (z.mod() < 1) {
                    result.add(z);
                }
            }
        }
        return result;
    }

    private Complex sequenceOfFunctions(Complex z, double k) {
        if (k < 1)
            return func1(z, k);
        else if (1 < k && k < 2.001)
            return func2(z, k - 1);
        else if (2 < k)
            return func3(z, k - 2);
        return z;
    }

    private Complex func1(Complex z, double k) {
        Complex inverse = Complex.valueOf(1).div(z);
        return z.mul(1 - k).sum((z.sum(inverse)).mul(-0.5 * k));
    }

    private Complex func2(Complex z, double k) {
        Complex inverse = Complex.valueOf(1).div(z);
        Complex start = (z.sum(inverse)).mul(-0.5 * 1);
        return start.root(1 + k);
    }

    private Complex func3(Complex z, double k) {
        Complex inverse = Complex.valueOf(1).div(z);
        Complex s = (z.sum(inverse)).mul(-0.5 * 1);
        Complex st = s.root(2);
        return st.mul(new Complex(Math.cos(Math.PI / 4 * k), -Math.sin(Math.PI / 4 * k)));
    }

    private Complex[] getFrame(double k) {
        List<Complex> result = startFunc();
        Complex[] frame = new Complex[result.size()];
        for (int i = 0; i < result.size(); i++) {
            frame[i] = sequenceOfFunctions(result.get(i), k);
        }
        return frame;
    }

}
