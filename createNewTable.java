package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void createNewTable() {

        String url = "jdbc:sqlite:C://sqlite/db/movie.db";

        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
                + "id integer PRIMARY KEY,\n"
                + "	movie_name text NOT NULL,\n"
                + "	actor_name text NOT NULL,\n"
                + "	actress_name text NOT NULL,\n"
                + "	director_name text NOT NULL,\n"
                + "	year_of_release  date NOT NULL \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }

}