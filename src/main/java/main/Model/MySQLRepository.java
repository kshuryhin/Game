package main.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRepository implements Repository{
    private int size;
    private int[][] grid;
    public MySQLRepository(int[][] grid){
        this.size = grid.length;
        this.grid = grid;
    }

    @Override
    public void save(int[][] grid) {
        for (int i = 0; i < size; i++) {
            DataBase.insertData(grid[i], i);
        }
    }

    @Override
    public void load() {
        int iter = 0;
        ResultSet rs = DataBase.getData();
        try {
            while (rs.next()) {
                grid[iter][0] = rs.getInt(1);
                grid[iter][1] = rs.getInt(2);
                grid[iter][2] = rs.getInt(3);
                grid[iter][3] = rs.getInt(4);
                iter++;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
