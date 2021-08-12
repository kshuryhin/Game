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

    public void addNewNumbers(boolean isMoved) {
        int x;
        int y;
        if (containsNull() && isMoved) {
            do {
                x = rand.nextInt(4);
                y = rand.nextInt(4);
            } while (grid[x][y] != 0);
            grid[x][y] = arr[rand.nextInt(2)];
        }
        this.isMoved = false;
    }

    public boolean containsNull() {
        boolean answer = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    answer = true;
                    break;
                }
            }
        }
        return answer;
    }

    public void start() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }
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

        for (int i = 0; i < 4; i++) {
            moveZeroes(grid[i]);
            sumElements(grid[i]);
            moveZeroes(grid[i]);
        }
    }

    public void moveUp() {
        int[] invert = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = grid[j][i];
            }

            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);

            for (int j = 0; j < 4; j++) {
                grid[j][i] = invert[j];
            }
        }
    }

    public void moveRight() {
        int[] invert = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = grid[i][invert.length - 1 - j];
            }
            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);
            for (int j = 0; j < 4; j++) {
                grid[i][j] = invert[invert.length - 1 - j];
            }
        }
    }

    public void moveDown() {
        int[] invert = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = grid[invert.length - 1 - j][i];
            }

            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);

            for (int j = 0; j < 4; j++) {
                grid[j][i] = invert[invert.length - 1 - j];
            }
        }
    }

    public void moveZeroes(int[] matrix) {
        int pos = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != 0) {
                if (i != pos) {
                    matrix[pos] = matrix[i];
                    matrix[i] = 0;
                    isMoved = true;
                }
                pos++;
            }
        }
    }

    public void sumElements(int[] mass) {

        for (int i = 0; i < mass.length - 1; i++) {
            if (mass[i] == mass[i + 1] && mass[i] != 0) {
                mass[i] = mass[i + 1] * 2;
                mass[i + 1] = 0;
                i++;
                isMoved = true;
            }
        }
    }


    public int score() {
        int maxValue = grid[0][0];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                }
            }
        }
        return maxValue;
    }

    public void add(boolean x, boolean y) {
        if (x || y) {
            addNewNumbers(true);
        }
    }
}