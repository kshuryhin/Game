package main.Model;

import java.io.IOException;
import java.sql.SQLException;

public interface Repository {
    void save(int[][] grid) throws IOException, SQLException;
    void load() throws SQLException, IOException, ClassNotFoundException;

}
