package main.Model;

import java.io.IOException;
import java.sql.SQLException;

public interface Repository {
    void save(Grid grid) throws IOException, SQLException;

    void load(Grid grid) throws SQLException, IOException, ClassNotFoundException;

}
