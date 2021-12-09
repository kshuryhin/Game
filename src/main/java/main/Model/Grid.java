package main.Model;

import java.io.Serializable;

public class Grid implements Serializable {
    private static final long serialVersionUID = -2578811478525278043L;

    private int size;
    private int[][] grid;
    private int TOP1_SCORE;
    private int TOP2_SCORE;
    private int TOP3_SCORE;

    public Grid(int size){
        this.size = size;
        grid = new int[size][size];
    }

    public Grid(){

    }

    public int getTOP1_SCORE() {
        return TOP1_SCORE;
    }

    public int getTOP2_SCORE() {
        return TOP2_SCORE;
    }

    public int getTOP3_SCORE() {
        return TOP3_SCORE;
    }

    public void setTOP1_SCORE(int TOP1_SCORE) {
        this.TOP1_SCORE = TOP1_SCORE;
    }

    public void setTOP2_SCORE(int TOP2_SCORE) {
        this.TOP2_SCORE = TOP2_SCORE;
    }

    public void setTOP3_SCORE(int TOP3_SCORE) {
        this.TOP3_SCORE = TOP3_SCORE;
    }

    public int getSize(){
        return this.size;
    }

    public int[][] getGrid(){
        return this.grid;
    }

    public void updateGrid(int[][] temp){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }
}
