package main;


import java.awt.*;

import javax.swing.*;

class Grid extends JPanel {
    int[] arr = new int[11];
    private final int size = 4;
    int[][] grid = new int[size][size];

    public Grid() {
        int k = 0;
        for (int i = 0; i < 11; i++) {
            arr[i] = (int) Math.pow(2, i + 1);
        }
    }

    public int rnd(int min, int max) {
        max -= min;
        return (int) ((Math.random() * ++max) + min);
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
                    g.drawString(String.valueOf(grid[i][j]), j * rowWid + rowWid / 3, (i + 1) * rowHt - rowHt / 3);
                }
            }
    }

    public void start () {
        int i = rnd(0, 3);
        int j = rnd(0,3);
        int x;
        int y;
        grid[i][j] = arr[rnd(0, 1)];
        do {
             x = rnd(0, 3);
             y = rnd(0, 3);
        } while (x == i && y == j);

        grid[x][y] = arr[rnd(0, 1)];

        repaint();
    }

    public void moveLeft () {
        int count = 0;
        int temp;
        int x;
        int y;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j > 0 ; j--) {
                if (grid[i][j] != 0 && grid[i][j-1] == 0) {
                    temp = grid[i][j-1];
                    grid[i][j-1] = grid[i][j];
                    grid[i][j] = temp;
                    count++;
                }
                if (grid[i][j] == grid[i][j-1]) {
                    grid[i][j] = 0;
                    grid[i][j-1] = grid[i][j-1] *2;
                }
            }
        }
        if (count != 0) {
            do {
                x = rnd(0,3);
                y = rnd(0,3);
            } while (grid[x][y] != 0 );

            grid[x][y] = arr[rnd(0, 1)];
        }

        repaint();
    }

}