package main.Model;

import java.sql.*;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:8889/store";
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

    public static void insertData(int[] arr, int i){
        String query = "UPDATE store.matrix\n" +
                "SET col1 = " + arr[0] + ", col2 = " + arr[1] + ", col3 = " + arr[2] + ", col4 = " + arr[3] + " WHERE row = " + i + ";";

        try{
            Connection connection = DataBase.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            connection.close();
            ps.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static ResultSet getData(){
        ResultSet rs = null;
        try{
            Connection connection = DataBase.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT col1, col2, col3, col4 FROM matrix");
            rs = ps.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return rs;
    }

}
