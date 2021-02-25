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
            //Problem with jdbc, not running without manual... 
            conn = DriverManager.getConnection("jdbc:sqlite:kurssit.db");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
        

            Scanner input = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("Valitse toiminto 1 - 4: ");
                    int action = Integer.parseInt(input.nextLine());
        
                    if (action == 5) {
                    System.exit(0);
                    input.close();
                    } else if (action == 1) {
                        function1(conn);
                    } else if (action == 2) {
                        function2(conn);
                    } else if (action == 3) {
                        function3(conn);
                    } else if (action == 4) {
                        function4(conn);
                    } else {
                    System.out.println("Kyseistä toimintoa ei ole olemassa.");
                    }
  
                }
                catch (NumberFormatException e) {
                    System.out.println("Kyseistä toimintoa ei ole olemassa.");
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   

    private static void function1(Connection c) {
        Scanner one = new Scanner(System.in);
        System.out.println("Summataan vuoden opintopisteet. Anna vuosi: ");
        String year = one.nextLine();

        // This is not the best query. YEAR() is not working?
        String query = "SELECT SUM(laajuus) as Laajuus FROM Suoritukset S, Kurssit K WHERE K.id=S.kurssi_id AND S.paivays like '"+year+"%'";        
        
        try (Statement stmt = c.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("Laajuus"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
    }

    private static void function2(Connection c) {
        Scanner two = new Scanner(System.in);
        System.out.println("Tulostetaan annetun opiskelijan kaikki suoritukset aikajärjestyksessä. Anna nimi: ");
        String name = two.nextLine();

        // SQL query ok, print not ok
        String query = "SELECT K.nimi as kurssi, K.laajuus as op, S.paivays as päiväys, S.arvosana as arvosana FROM Kurssit K, Suoritukset S, Opiskelijat O WHERE K.id=S.kurssi_id AND O.id=S.opiskelija_id AND O.nimi='"+name+"' ORDER BY S.paivays;";
        
        try (Statement stmt = c.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("kurssi"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
    }

    private static void function3(Connection c) {
        Scanner three = new Scanner(System.in);
        System.out.println("Toiminto3");
    }

    private static void function4(Connection c) {
        Scanner four = new Scanner(System.in);
        System.out.println("Toiminto4");
    }
}