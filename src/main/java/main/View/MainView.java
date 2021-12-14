package main.View;

import main.Controller.GameController;
import main.Model.DataBase;
import main.Model.Grid;
import main.Model.Score;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainView extends JFrame {
    private Grid grid;
    GridView gridView;
    GameController controller;
    JButton start;
    JButton left;
    JButton right;
    JButton up;
    JButton down;
    JButton save;
    JButton load;

    JLabel score;
    JLabel maxScore;



    public MainView(Grid grid){
        this.grid = grid;
        gridView = new GridView(grid);
        controller = new GameController(grid);
        try {
            createElements();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gridView.setBounds(50, 50, 800, 800);
        createActionListeners();
        setLayout(null);
        setSize(1500, 1000);
        add(gridView);
    }

    private void createActionListeners(){
        left.addActionListener(e ->
        {
            controller.moveLeft();
            gridView.repaint();
            updateScore();
            endGame();
        });
        add(left);

        start.addActionListener(e ->{
            gridView.repaint();
            controller.start();
            updateScore();
            try {
                updateRecord();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            endGame();
        });
        add(start);
        updateScore();

        up.addActionListener(e->{
            updateScore();
            controller.moveUp();
            gridView.repaint();
            updateScore();
            endGame();
        });
        add(up);

        right.addActionListener(e->{
            updateScore();
            controller.moveRight();
            gridView.repaint();
            updateScore();
            endGame();
        });
        add(right);

        down.addActionListener(e->{
            updateScore();
            controller.moveDown();
            gridView.repaint();
            updateScore();
            endGame();
        });
        add(down);

        save.addActionListener(e->{
            try {
                controller.saveGame();
                updateRecord();
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        });
        add(save);


        load.addActionListener(e -> {
            try {
                controller.uploadGame();
            } catch (IOException | SQLException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }finally {
                gridView.repaint();
            }
        });
        add(load);
    }



    private void createElements() throws SQLException {
        start = initButton("Start game", 1060, 50, 200, 100);
        left = initButton("Left", 1000, 400, 100, 50);
        right = initButton("Right", 1200, 400, 100, 50);
        up = initButton("Up", 1100, 300, 100, 50);
        down = initButton("Down", 1100, 500, 100, 50);
         save = initButton("Save", 1100, 600, 100, 50);
         load = initButton("Load", 1200, 600, 100, 50);

        score = initLabel(String.valueOf(controller.score()), 900, 650, 100, 100);
        maxScore = initLabel(String.valueOf(controller.getRecord()), 1100, 650, 100, 100);

    }

    private JButton initButton(String s, int x, int y, int w, int h) {
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

    public void updateScore () {
       score.setText(String.valueOf(controller.score()));
        add(score);
        score.repaint();
    }

    public void updateRecord() throws SQLException {
        maxScore.setText(String.valueOf(controller.getRecord()));
        add(maxScore);
        maxScore.repaint();

    }

    public void endGame () {
        if (controller.score() == 2048) {
            int input = JOptionPane.showOptionDialog(null, "You win! If you want to " +
                            "play again" +
                            " press OK", "Win",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, null, null);

            if(input == JOptionPane.OK_OPTION)
            {
                controller.start();
                gridView.repaint();
            }
            if (input == JOptionPane.OK_CANCEL_OPTION) {
                System.exit(1);
            }
        }

        if (!controller.containsNull()) {
            int input = JOptionPane.showOptionDialog(null, "You loose! If you want to " +
                            "play again" +
                            " press OK", "Loose",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, null, null);

            if(input == JOptionPane.OK_OPTION)

            {
                controller.start();
                gridView.repaint();
            }
            if (input == JOptionPane.OK_CANCEL_OPTION) {
                System.exit(1);
            }
        }
    }

}
