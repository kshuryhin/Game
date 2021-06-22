package main;

import java.awt.Graphics;
import java.awt.*;

import javax.swing.*;

public class Main {
    public Main() {
        Grid xyz = new Grid();
        JFrame frame = new JFrame("Grid");
        frame.setSize(1000, 1000);
        xyz.setBackground(Color.ORANGE);
        frame.setLayout(null);
        xyz.setBounds(50, 50, 800, 800);
        frame.add(xyz);
        frame.setVisible(true);
//        MyComponent component = new MyComponent();

//        JLabel label = new JLabel("2");
//       label.setBounds(1000,2000, 115, 130);

//        add(label);
    }

    public static void main(String[] a) {


        new Main();


    }
}