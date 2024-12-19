package org.example;

import org.example.lab1.FractalDrawer;
import org.example.lab1.fractals.Fractal;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Main extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static Fractal typeFractal = Fractal.NEWTON;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel();
        FractalDrawer fractalDrawer = new FractalDrawer(WIDTH, HEIGHT);
        label.setIcon(fractalDrawer);
        fractalDrawer.draw(typeFractal);
        frame.addKeyListener(new KeyAdapter() {
            private double count_x = -0.5;
            private double count_y = 0.5;

            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyChar() + "/" + e.getKeyCode());
                //esc
                if (e.getKeyCode() == 27)  {

                }
                // arrow right
                if (e.getKeyCode() == 37)  {
                    count_x += 0.01;
                }
                // arrow left
                if (e.getKeyCode() == 39)  {
                    count_x -= 0.01;
                }
                // arrow up
                if (e.getKeyCode() == 38)  {
                    count_y += 0.01;
                }
                // arrow down
                if (e.getKeyCode() == 40) {
                    count_y -= 0.01;
                }

                if(e.getKeyCode() == 49){
                    typeFractal = Fractal.NEWTON;
                }

                if(e.getKeyCode() == 50){
                    typeFractal = Fractal.JULIA;
                }

                if(e.getKeyCode() == 51){
                    typeFractal = Fractal.MANDELBROT;
                }

                fractalDrawer.drawMove(typeFractal, count_x % 2.0, count_y % 2.0);
                label.repaint();
            }
        });

        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}