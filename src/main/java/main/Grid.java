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
        int rowHt = height / (size) - 1 ;
        int rowWid = width / (size) - 1;

        Font myFont = new Font("Courier New", 1, rowHt);
        g.setFont(myFont);

        for (i = 0; i <= size; i++) {

            g.drawLine(0, i * rowHt, width, i * rowHt);

        }


        // draw the columns
        for (i = 0; i <= size; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);

        }
//        int k = (int)(0.85 * rowHt);
//        int l = (int)(0.85 * rowWid);

        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){

                g.setColor(Color.orange);

                if (i == 1 && j == 2) {
                    g.drawString("4", i * rowHt + 25, j * rowWid - 15);
                }

                if (i == 3 && j == 3) {
                    g.drawString("2", i * rowHt + 25, j * rowWid - 15);

                }



            }

        }


    }


}