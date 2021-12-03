package main.Model;

import java.io.*;
import java.util.Scanner;

public class FileRepository implements Repository{
    private int[][] grid;
    private int size;

    public FileRepository(int [][] grid){
        this.grid = grid;
        this.size = grid.length;
    }

    @Override
    public void save(int[][] grid) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(grid);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Override
    public void load() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int[][] newGrid = new int[size][size];
        newGrid = (int[][]) objectInputStream.readObject();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = newGrid[i][j];
            }
        }
        objectInputStream.close();

    }
}
