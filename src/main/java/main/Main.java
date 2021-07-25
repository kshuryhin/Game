 package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

    JFrame frame = new JFrame("Grid");
    Grid gr = new Grid();

    JButton start = initButton("Start game", 1060, 50, 200, 100);
    JButton left = initButton("Left", 1000, 400, 100, 50);
    JButton right = initButton("Right", 1200, 400, 100, 50);
    JButton up = initButton("Up", 1100, 300, 100, 50);
    JButton down = initButton("Down", 1100, 500, 100, 50);

    public Main() {
        gr.setBounds(50, 50, 800, 800);
        click();

        frame.setLayout(null);
        frame.setSize(1500, 1000);
        frame.add(gr);
        frame.setVisible(true);
    }

    public void click () {
        left.addActionListener(e ->
        {
            gr.moveLeft();
            gr.repaint();
            gr.addNewNumbers(gr.isMoved);
            gr.repaint();
        });
        frame.add(left);

        start.addActionListener(e ->{
            gr.start();
            gr.repaint();
        });
        frame.add(start);

        up.addActionListener(e->{
            gr.moveUp();
            gr.repaint();
            gr.addNewNumbers(gr.isMoved);
            gr.repaint();
        });
        frame.add(up);

        right.addActionListener(e->{
            gr.moveRight();
            gr.repaint();
            gr.addNewNumbers(gr.isMoved);
            gr.repaint();
        });
        frame.add(right);

        down.addActionListener(e->{
            gr.moveDown();
            gr.repaint();
            gr.addNewNumbers(gr.isMoved)
            ;
            gr.repaint();
        });
        frame.add(down);
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