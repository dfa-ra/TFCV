package org.example;

import org.example.lab1.FractalDrawer;
import org.example.lab1.FractalFrame;
import org.example.lab1.fractals.Fractal;
import org.example.lab2.GraphFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Main extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame mainFrame = new JFrame("Main Window");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new FlowLayout());

        JButton openLab1 = new JButton("Open lab 1");
        JButton openLab2 = new JButton("Open lab 2");

        mainFrame.add(openLab1);
        mainFrame.add(openLab2);

        openLab1.addActionListener(e -> openNewWindow(mainFrame, new FractalFrame(mainFrame)));
        openLab2.addActionListener(e -> openNewWindow(mainFrame, new GraphFrame(mainFrame)));

        mainFrame.setLocationRelativeTo(null); // Center the window
        mainFrame.setVisible(true);
    }

    private static void openNewWindow(JFrame parent, JFrame newFrame) {
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                parent.setVisible(true);
            }
        });

        newFrame.setLocationRelativeTo(parent); // Center relative to parent
        parent.setVisible(false);
        newFrame.setVisible(true);

        // Request focus for KeyListener to work
        newFrame.requestFocus();
    }

}