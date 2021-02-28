import java.sql.*;
import java.util.*;

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
                    System.out.println("Valitse toiminto 1 - 4 kyselyitä varten ja 5 lopettaaksesi ohjelman: ");
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
        System.out.println("Laske annettuna vuonna saatujen opintopisteiden yhteismäärä. Anna vuosi: ");
        String year = one.nextLine();

        // This is not the best query. YEAR() is not working?
        // ToDo: Figure out why YEAR() not working
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
        System.out.println("Tulosta annetun opiskelijan kaikki suoritukset aikajärjestyksessä. Anna opiskelijan nimi: ");
        String name = two.nextLine();

        // SQL query ok, print not ok
        // ToDo: Fix print
        String query = "SELECT K.nimi as kurssi, K.laajuus as op, S.paivays as päiväys, S.arvosana as arvosana FROM Kurssit K, Suoritukset S, Opiskelijat O WHERE K.id=S.kurssi_id AND O.id=S.opiskelija_id AND O.nimi='"+name+"' ORDER BY S.paivays;";
        
        try (Statement stmt = c.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("kurssi"));
                System.out.println(rs.getString("op"));
                System.out.println(rs.getString("päiväys"));
                System.out.println(rs.getString("arvosana"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
    }

    private static void function3(Connection c) {
        Scanner three = new Scanner(System.in);
        System.out.println("Tulosta annetun kurssin suoritusten arvosanojen jakauma. Anna kurssin nimi: ");
        String name = three.nextLine();

        // ToDo: SQL query
        String query = "SELECT arvosana, COUNT(*) as määrä FROM Kurssit K, Suoritukset S WHERE K.id=S.kurssi_id AND K.nimi='"+name+"' GROUP BY S.arvosana;";
        
        try (Statement stmt = c.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("arvosana"));
                System.out.println(rs.getString("määrä"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
    }

    private static void function4(Connection c) {
        Scanner four = new Scanner(System.in);
        System.out.println("Tulosta top x eniten opintopisteitä antaneet opettajat. Anna opettajien määrä: ");
        String amount = four.nextLine();

        // Printing is the problem
        // ToDo: Fix printing
        String query = "SELECT O.nimi as opettaja, SUM(K.laajuus) as op FROM Opettajat O, Kurssit K, Suoritukset S WHERE K.id=S.kurssi_id AND O.id=K.opettaja_id GROUP BY O.id ORDER BY op DESC LIMIT "+amount+";";
        
        try (Statement stmt = c.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("opettaja"));
                System.out.println(rs.getString("op"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
    }
}