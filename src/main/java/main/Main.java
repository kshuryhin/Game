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

    JLabel score = initLabel(String.valueOf(gr.score()), 1100, 650, 100, 100);

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
            gr.addNewNumbers();
            gr.repaint();
            updateScore();
            endGame();
        });
        frame.add(left);

        start.addActionListener(e ->{
            updateScore();
            gr.start();
            gr.repaint();
            updateScore();
            endGame();
        });
        frame.add(start);

        up.addActionListener(e->{
            updateScore();
            gr.moveUp();
            gr.repaint();
            gr.addNewNumbers();
            gr.repaint();
            updateScore();
            endGame();
        });
        frame.add(up);

        right.addActionListener(e->{
            updateScore();
            gr.moveRight();
            gr.repaint();
            gr.addNewNumbers();
            gr.repaint();
            updateScore();
            endGame();
        });
        frame.add(right);

        down.addActionListener(e->{
            updateScore();
            gr.moveDown();
            gr.repaint();
            gr.addNewNumbers();
            gr.repaint();
            updateScore();
            endGame();
        });
        frame.add(down);
    }

    public  void updateScore () {
        score.repaint();
        score.setText(String.valueOf(gr.score()));
        frame.add(score);
    }

    public void endGame () {
        if (gr.score() == 2048) {
            int input = JOptionPane.showOptionDialog(null, "You win! If you want to " +
                            "play again" +
                            " press OK", "Win",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, null, null);

            if(input == JOptionPane.OK_OPTION)
            {
                gr.start();
            }
            if (input == JOptionPane.OK_CANCEL_OPTION) {
                System.exit(1);
            }
        }

        if (!gr.containsNull()) {
            int input = JOptionPane.showOptionDialog(null, "You loose! If you want to " +
                            "play again" +
                            " press OK", "Loose",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, null, null);

            if(input == JOptionPane.OK_OPTION)

            {
                gr.start();
            }
            if (input == JOptionPane.OK_CANCEL_OPTION) {
                System.exit(1);
            }
        }
    }

    public static JButton initButton(String s, int x, int y, int w, int h) {
        JButton b = new JButton(s);
        b.setBounds(x, y, w, h);
        b.setBackground(Color.WHITE);
        return b;
    }

    public static JLabel initLabel (String s, int x, int y, int w, int h) {
        JLabel label = new JLabel(s, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 14));
        label.setBounds(x, y, w, h);
        label.setOpaque( true );
        label.setBackground(Color.ORANGE);
        return label;
    }

    public static void main(String[] a) {
       new Main();
    }
}