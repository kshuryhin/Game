package main;

import java.awt.Graphics;
import java.awt.*;

import javax.swing.*;

public class Main {
    public Main() {
        Grid xyz = new Grid();
        JFrame frame = new JFrame("Grid");
        frame.setSize(1500, 1000);
        xyz.setBackground(Color.ORANGE);
        frame.setLayout(null);
        xyz.setBounds(50, 50, 800, 800);
//        Icon icon = new ImageIcon("C:/images/Left.png");
        JButton button = new JButton("Start Game");
        JButton buttonLeft = new JButton("Left");
        JButton buttonRight = new JButton("Right");
        JButton buttonTop = new JButton("Top");
        JButton buttonDown = new JButton("Down");
//        JButton button1 = new JButton(icon);
        button.setBounds(1060, 50, 200, 100);
        buttonLeft.setBounds(1000, 400, 100, 50);
        buttonRight.setBounds(1200, 400, 100, 50);
        buttonTop.setBounds(1100, 300, 100, 50);
        buttonDown.setBounds(1100, 500, 100, 50);


//        button1.setBounds(1200, 90, 50, 60);
        button.setBackground(Color.WHITE);
        buttonLeft.setBackground(Color.WHITE);
        buttonRight.setBackground(Color.WHITE);
        buttonTop.setBackground(Color.WHITE);
        buttonDown.setBackground(Color.WHITE);


//        Box box = Box.createVerticalBox();
//        box.add(button1);

//        frame.add(box);
//        frame.add(button1);
        frame.add(button);
        frame.add(buttonLeft);
        frame.add(buttonRight);
        frame.add(buttonTop);
        frame.add(buttonDown);
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