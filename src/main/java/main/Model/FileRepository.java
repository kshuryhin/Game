package main.Model;

import java.io.*;
import java.util.Scanner;

public class FileRepository implements Repository{


    public FileRepository(int [][] grid){
    }

    //обернуть в try with resources 17, 18 lines and other
    @Override
    public void save(Grid grid) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(grid);
            objectOutputStream.flush();
        }
    }

    @Override
    public void load(Grid grid) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream("test.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Grid temp =  (Grid) objectInputStream.readObject();
            grid.updateGrid(temp.getGrid());
        }
    }
}
