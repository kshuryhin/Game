package main;

import java.awt.*;

import javax.swing.*;

public class Main {
    public Main() {
        Grid gr = new Grid();
        gr.setBackground(Color.ORANGE);
        gr.setBounds(50, 50, 800, 800);

        JButton b = initButton("Start game", 1060, 50, 200, 100);
        JButton b1 = initButton("Left", 1000, 400, 100, 50);
        JButton b2 = initButton("Right", 1200, 400, 100, 50);
        JButton b3 = initButton("Up", 1100, 300, 100, 50);
        JButton b4 = initButton("Down", 1100, 500, 100, 50);

        JFrame frame = new JFrame("Grid");
        frame.setLayout(null);
        frame.setSize(1500, 1000);
        frame.add(b);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(gr);
        frame.setVisible(true);
    }

    public static JButton initButton(String s, int x, int y, int w, int h) {
        JButton b = new JButton(s);
        b.setBounds(x, y, w, h);
        b.setBackground(Color.WHITE);
        return b;
    }

    public static void main(String[] a) {
        new Main();
    }
}