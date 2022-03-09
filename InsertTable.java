package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertTable {

    private Connection connect() {
        String url = "jdbc:sqlite:G://sqlite/db/movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(int id, String movie_name, String actor_name, String actress_name, String director_name,
            LocalDate year_of_release) {
        String sql = "INSERT INTO movies(id ,movie_name ,actor_name ,actress_name ,director_name, year_of_release ) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setint(1, id);
            pstmt.setString(2, movie_name);
            pstmt.setString(3, actor_name);
            pstmt.setString(4, actress_name);
            pstmt.setString(5, director_name);
            pstmt.setLocalDate(6, year_of_release);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertTable app = new InsertTable();
        app.insert(101, "Koi Mil Gaya", "Hrithik Roshan", "Preity Zinta", "Rakesh Roshan", "01-08-2003");
        app.insert(102, "Krrish", "Hrithik Roshan", "Priyanka Chopra", "Rakesh Roshan", "23-06-2006");
        app.insert(103, "Krrish3", "Hrithik Roshan", "Priyanka Chopra", "Rakesh Roshan", "01-11-2013");
    }

}