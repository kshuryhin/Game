package main;



import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Let's play!");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setLayout(new GridBagLayout());

        JButton myButton = new JButton("Click");
        JButton myButton2 = new JButton("Click Again");

        myButton.setBackground(new Color(112, 95, 32));
        myButton2.setForeground(Color.blue);
        frame.add(myButton);
        frame.add(myButton2);

    }
}

