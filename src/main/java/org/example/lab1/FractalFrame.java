package org.example.lab1;

import org.example.lab1.fractals.Fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FractalFrame extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private static Fractal typeFractal = Fractal.NEWTON;

    public FractalFrame(JFrame parent) {
        setTitle("Fractal");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel();
        FractalDrawer fractalDrawer = new FractalDrawer(WIDTH, HEIGHT);
        label.setIcon(fractalDrawer);
        fractalDrawer.draw(typeFractal);
        addKeyListener(new KeyAdapter() {
            private double count_x = -0.5;
            private double count_y = 0.5;

            public void keyPressed(KeyEvent e) {
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

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                    parent.setVisible(true);
                }

                fractalDrawer.drawMove(typeFractal, count_x % 2.0, count_y % 2.0);
                label.repaint();
            }
        });

        getContentPane().add(label, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }
}
