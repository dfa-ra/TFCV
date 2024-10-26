package org.example;

import org.example.fractals.Fractal;

import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel();
        FractalDrawer fractalDrawer = new FractalDrawer(WIDTH, HEIGHT);
        label.setIcon(fractalDrawer);
        fractalDrawer.draw(Fractal.NEWTON);

        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}