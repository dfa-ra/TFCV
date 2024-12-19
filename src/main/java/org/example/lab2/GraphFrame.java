package org.example.lab2;

import org.example.lab1.FractalDrawer;
import org.example.lab1.fractals.Fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GraphFrame extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    public GraphFrame(JFrame parent) {
        setTitle("Graph");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel();
        GraphDrawer graphDrawer = new GraphDrawer(WIDTH, HEIGHT);
        label.setIcon(graphDrawer);
        graphDrawer.draw();
        addKeyListener(new KeyAdapter() {
            private double k = 0;

            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyChar() + "/" + e.getKeyCode());

                if (e.getKeyCode() == 39)  {
                    k += 0.05;
                }

                if (e.getKeyCode() == 37)  {
                    k -= 0.05;
                }

                if (k > 3) k = 3;
                if (k < 0) k = 0;
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                    parent.setVisible(true);
                }
                System.out.println(k);
                graphDrawer.drawMove(k);
                label.repaint();
            }
        });

        getContentPane().add(label, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }
}
