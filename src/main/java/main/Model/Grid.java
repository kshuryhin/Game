package main.Model;

public class Grid {
    private int size;
    private int[][] grid;

    public Grid(int size){
        this.size = size;
        grid = new int[size][size];
    }

    public Grid(){

    }

    public int getSize(){
        return this.size;
    }

    public int[][] getGrid(){
        return this.grid;
    }

}
