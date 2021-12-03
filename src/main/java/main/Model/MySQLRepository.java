package main.Model;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRepository implements Repository{
    private int size;
    private int[][] grid;
    public MySQLRepository(int[][] grid) throws IOException {
        this.size = grid.length;
        this.grid = grid;
    }

    @Override
    public void save(int[][] grid) throws SQLException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(grid);
        objectOutputStream.close();
        DataBase.insertSerializable(size, baos.toByteArray());
    }

    @Override
    public void load() throws SQLException, IOException, ClassNotFoundException {
        ResultSet rs = DataBase.getSerializableData(size);
        byte[] buf = null;
        while (rs.next()){
            buf = rs.getBytes("grid");
        }

        if (buf!=null){
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(buf));
            int[][] temp = (int[][]) objectInputStream.readObject();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    grid[i][j] = temp[i][j];
                }
            }
        }
    }

}
