import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class testi {

    private static void createTable(Statement statement) {
        try {
          statement.execute("CREATE TABLE Elokuvat (id INT PRIMARY KEY, nimi TEXT NOT NULL, vuosi INT);");
          System.out.println("Luotu Elokuvat taulu");
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }

    private static int randYear(int min, int max) {
        return min + (int)(Math.random() * ((max-min)+1));
    }
    
    private static String randString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 15;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        return generatedString;
    }
    
    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:testi.db");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);

            createTable(statement);
    
            Scanner input = new Scanner(System.in);
            while (true) {
            try {
                System.out.println("Valitse toiminto 1 - 4 kyselyitä varten ja 5 lopettaaksesi ohjelman: ");
                int toiminto = Integer.parseInt(input.nextLine());
    
                if (toiminto == 5) {
                System.exit(0);
                input.close();
                } else if (toiminto == 1) {
                    addButtLoadOfRows(conn);;
                }
            
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addButtLoadOfRows(Connection conn) {
        try {
            PreparedStatement start = conn.prepareStatement("BEGIN");
            PreparedStatement end = conn.prepareStatement("END;");
            
            start.executeUpdate();
            for (int i=0; i<10; i++) {
              PreparedStatement p = conn.prepareStatement(
                "INSERT INTO Elokuvat (nimi, vuosi) VALUES(?, ?)"
              );
              
                String randString = randString();
                int randYear = randYear(1900,2000);
                p.setString(1, randString);
                p.setInt(2, randYear);
                p.executeUpdate();
            }
            end.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lisätty rivit ajassa: ");
    }
}