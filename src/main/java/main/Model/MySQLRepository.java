package main.Model;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRepository implements Repository{
    public MySQLRepository() throws IOException {

    }

    @Override
    public void save(Grid grid) throws SQLException, IOException {
        try(    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos)){
            objectOutputStream.writeObject(grid);
            DataBase.insertSerializable(grid.getSize(), baos.toByteArray());
        }
    }

    @Override
    public void load(Grid grid) throws SQLException, IOException, ClassNotFoundException {
        try( ResultSet rs = DataBase.getSerializableData(grid.getSize())){
            byte[] buf = null;
            while (rs.next()){
                buf = rs.getBytes("grid");
            }
            if (buf!=null){
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(buf));
                Grid temp = (Grid) objectInputStream.readObject();
                grid.updateGrid(temp.getGrid());
            }
        }


    }

}
