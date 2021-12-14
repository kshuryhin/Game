package main.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

    //try with resources
    public static void insertSerializable(int size, byte[] arr) throws SQLException {
        try(Connection connection = getConnection()){
            PreparedStatement ps = connection.prepareStatement("INSERT INTO save_game(size, grid) VALUES(?,?)" +
                    "ON DUPLICATE KEY UPDATE grid=? ");
            ps.setInt(1, size);
            ps.setBytes(2, arr);
            ps.setBytes(3, arr);
            ps.executeUpdate();
        }
    }

    public static ResultSet getSerializableData(int size) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT grid FROM save_game WHERE size=? " +
                "AND id=(SELECT MAX(id) " +
                "FROM save_game )");
        ps.setInt(1,size);
        rs = ps.executeQuery();
        return rs;

    }

    public static void updateScore(PriorityQueue<Integer> queue) throws SQLException {
        try(Connection connection = getConnection()){
            PreparedStatement updateFirst = connection.prepareStatement("UPDATE score SET score=? WHERE id=1");
            PreparedStatement updateSecond = connection.prepareStatement("UPDATE score SET score=? WHERE id=2");
            PreparedStatement updateThird = connection.prepareStatement("UPDATE score SET score=? WHERE id=3");

            updateFirst.setInt(1, queue.poll());
            updateSecond.setInt(1, queue.poll());
            updateThird.setInt(1, queue.poll());

            updateFirst.executeUpdate();
            updateSecond.executeUpdate();
            updateThird.executeUpdate();
        }

    }

    public static PriorityQueue<Integer> getScore() throws SQLException {
        try(Connection connection = getConnection()){
            PreparedStatement ps = connection.prepareStatement("SELECT score FROM score");
            ResultSet rs = ps.executeQuery();
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            while (rs.next()){
                queue.add(rs.getInt("score"));
            }
            return queue;
        }
    }

}
