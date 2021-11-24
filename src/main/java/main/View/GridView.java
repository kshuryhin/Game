package main.View;

import main.Controller.GameController;
import main.Model.Grid;

import javax.swing.*;
import java.awt.*;

public class GridView extends JPanel {
    private int[][] matrix;
    private int size;


    public GridView(Grid grid){
        this.matrix = grid.getGrid();
        size = matrix.length;
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
                g.drawString(GameController.zeroCheck(matrix[i][j]), j * rowWid + rowWid / 3, (i + 1) * rowHt - rowHt / 3);
            }
        }
    }
}
