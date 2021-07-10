package main;


import java.awt.*;

import javax.swing.*;

class Grid extends JPanel {
    int flag;
    int[] arr = new int[11];
    private final int size = 4;
    int[][] grid = new int[size][size];

    public Grid() {
        int k = 0;
        for (int i = 0; i < 11; i++) {
            arr[i] = (int) Math.pow(2, i + 1);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = arr[k];
                k++;
                if (k == 11) {
                    k = 0;
                }
            }
        }
    }

    public int rnd() {
        int min = 0;
        int max = 3;
        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }

    public void start() {
        flag = 1;
        paint(getGraphics());
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

        if (flag == 0) {
            for (i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    g.setColor(Color.orange);
                    g.drawString("", j * rowWid + rowWid / 3, (i + 1) * rowHt - rowHt / 3);
                }
            }
        } else if (flag == 1) {
            g.setColor(Color.orange);
            g.drawString(String.valueOf(2), rnd() * rowWid + rowWid / 3, (rnd() + 1) * rowHt - rowHt / 3);
            g.drawString(String.valueOf(4), rnd() * rowWid + rowWid / 3, (rnd() + 1) * rowHt - rowHt / 3);//
        }
    }
}