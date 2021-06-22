package main;

import java.awt.*;

import javax.swing.*;

class Grid extends JPanel {
    private int size = 4;
    private int[][] grid = new int[size][size];


    public void paint(Graphics g) {

        int i;
        int width = getSize().width;
        int height = getSize().height;

        // draw the rows
        int rowHt = height / (size);
        int rowWid = width / (size);

        Font myFont = new Font("Courier New", 1, rowHt);
        g.setFont(myFont);

        for (i = 0; i < size; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);

        }


        // draw the columns
        for (i = 0; i < size; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);

        }

        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                g.drawString(String.valueOf(grid[i][j]), i * rowHt, j * rowWid);

            }

        }


    }


}