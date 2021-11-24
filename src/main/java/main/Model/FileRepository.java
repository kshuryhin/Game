package main.Model;

import java.io.*;
import java.util.Scanner;

public class FileRepository implements Repository{
    File fload = new File("load");
    private int[][] grid;
    private int size;

    public FileRepository(int [][] grid){
        this.grid = grid;
        this.size = grid.length;
    }

    @Override
    public void save(int[][] grid) {
        PrintWriter wr = null;
        try {
            wr = new PrintWriter(fload);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                wr.print(grid[i][j]);
                wr.print("\t");
            }
            wr.print("\n");
        }

        wr.close();
    }

    @Override
    public void load() {
        try {
            FileReader fr = new FileReader("load");
            Scanner scanner = new Scanner(fr);


            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            fr.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
