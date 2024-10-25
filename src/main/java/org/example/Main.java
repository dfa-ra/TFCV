package org.example;

import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {

    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label=new JLabel();
        label.setIcon(new FractalDrawer());
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}