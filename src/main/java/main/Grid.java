package main;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

class Grid extends JPanel {
    private int[] arr = new int[11];
    private final int size = 4;
    private int[][] grid = new int[size][size];
    private Random rand = new Random(System.currentTimeMillis());
    public boolean isMoved = false;

    public Grid() {
        int k = 0;
        for (int i = 0; i < 11; i++) {
            arr[i] = (int) Math.pow(2, i + 1);
        }
    }

    public void paint(Graphics g) {
        int i;
        int width = getSize().width;
        int height = getSize().height;
        // draw the rows
        int rowHt = height / (size);
        int rowWid = width / (size);

        Font myFont = new Font("Serif", 1, 60);
        g.setFont(myFont);

        for (i = 0; i <= size; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);
        }
        // draw the columns
        for (i = 0; i <= size; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }

        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.setColor(Color.orange);
                g.drawString(nullCheck(grid[i][j]), j * rowWid + rowWid / 3, (i + 1) * rowHt - rowHt / 3);
            }
        }
    }

    private String nullCheck(int x) {
        if (x == 0) {
            return "";
        }
        return String.valueOf(x);
    }

    public void addNewNumbers (boolean isMoved) {
        int x;
        int y;
        boolean containsNull = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    containsNull = true;
                    break;
                }
            }
        }
        if (containsNull && isMoved) {
            do {
                x = rand.nextInt(4);
                y = rand.nextInt(4);
            } while (grid[x][y] != 0);
            grid[x][y] = arr[rand.nextInt(2)];
        }
        this.isMoved = false;
    }

    public void start() {
        int i = rand.nextInt(4);
        int j = rand.nextInt(4);
        int x;
        int y;
        grid[i][j] = arr[rand.nextInt(2)];
        do {
            x = rand.nextInt(4);
            y = rand.nextInt(4);
        } while (x == i && y == j);
        grid[x][y] = arr[rand.nextInt(2)];
        repaint();
    }

    public void moveLeft() {
        int temp;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j > 0; j--) {
                if (grid[i][j] != 0 && grid[i][j - 1] == 0) {
                    temp = grid[i][j - 1];
                    grid[i][j - 1] = grid[i][j];
                    grid[i][j] = temp;
                    isMoved = true;
                }
                if (grid[i][j] != 0 && grid[i][j] == grid[i][j - 1]) {
                    grid[i][j] = 0;
                    grid[i][j - 1] = grid[i][j - 1] * 2;
                    isMoved = true;
                }
            }
        }
    }

    public void moveUp () {
        int temp = 0;
        for (int j = 0; j < grid[0].length ; j++) {
            for (int i = grid.length-1; i > 0; i--) {
                if (grid[i][j] != 0 && grid[i-1][j] == 0) {
                    temp = grid[i][j];
                    grid[i][j] = grid[i-1][j];
                    grid[i-1][j] = temp;
                    isMoved = true;
                }

                if (grid[i][j] != 0 && grid[i][j] == grid[i-1][j]) {
                    grid[i][j] = 0;
                    grid[i-1][j] = grid[i-1][j]*2;
                    isMoved = true;
                }
            }
        }
    }

    public void moveRight () {

    }

    public void moveDown () {

    }
}