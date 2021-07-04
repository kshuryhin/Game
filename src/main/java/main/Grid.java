package main;


import java.awt.*;

import javax.swing.*;

class Grid extends JPanel {
    public Grid() {
        int k = 0;
        for (int i = 0; i < 11; i++) {
            arr[i] = (int)Math.pow(2, i + 1);
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
    int arr[] = new int[11];

    private int size = 4;
    int[][] grid = new int[size][size];


    public void paint(Graphics g) {
        int i;
        int width = getSize().width;
        int height = getSize().height;
        // draw the rows
        int rowHt = height / (size);
        int rowWid = width / (size);

        Font myFont = new Font("Serif", 1, 80);
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
        int k = 0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.setColor(Color.orange);
                g.drawString(String.valueOf(arr[k]), j * rowWid, (i + 1) * rowHt);
                k++;
                if (k == 11) {
                    k = 0;
                }
            }

        }


    }


}