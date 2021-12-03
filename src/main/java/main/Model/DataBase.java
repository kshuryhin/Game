package main.Model;

import java.sql.*;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:8889/2048";
    private static final String user = "root";
    private static final String password = "root";

    private  static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the MySQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }

    public static void insertSerializable(int size, byte[] arr) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO save_game(size, grid) VALUES(?,?)" +
                "ON DUPLICATE KEY UPDATE grid=? ");
        ps.setInt(1, size);
        ps.setBytes(2, arr);
        ps.setBytes(3, arr);
        ps.executeUpdate();
    }

    public static ResultSet getSerializableData(int size) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT grid FROM save_game WHERE size=?");
        ps.setInt(1,size);
        rs = ps.executeQuery();
        return rs;
    }

}
