import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class kanta {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./kurssit.db");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            System.out.println("Toimii");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}