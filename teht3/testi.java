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
                System.out.println("Valitse toiminto 1 tai 2 kyselyitä varten ja 3 lopettaaksesi ohjelman: ");
                int action = Integer.parseInt(input.nextLine());
    
                if (action == 3) {
                System.exit(0);
                input.close();
                } else if (action == 1) {
                    addButtLoadOfRows(conn);
                } else if (action == 2) {
                    lotOfQuerys(conn);
                } else if (action == 66) {
                    order66(statement);
                }
            
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addIndex(Connection conn) {
        try {
            PreparedStatement index = conn.prepareStatement("CREATE INDEX vuosi_index ON Elokuvat (vuosi)");

            index.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    private static void addButtLoadOfRows(Connection conn) {
        long startTime = 0;
        long endTime = 0;

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Käytetäänkö indeksin tehoststa? (1 -> kyllä, 2 -> ei) ");
            int action = Integer.parseInt(input.nextLine());

            PreparedStatement start = conn.prepareStatement("BEGIN");
            PreparedStatement end = conn.prepareStatement("END;");
            startTime = System.nanoTime();
            
            start.executeUpdate();
            if (action == 1) {
                addIndex(conn);
            } else {
                System.out.println("Nyt kestää, älä pidätä hengitystä.");
            }

            for (int i=0; i<1000000; i++) {
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
            endTime = System.nanoTime();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lisätty rivit ajassa:");
        System.out.println((endTime-startTime)/1000000000);
    }

    private static void lotOfQuerys(Connection conn) {
        long startTime = 0;
        long endTime = 0;

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Käytetäänkö indeksin tehoststa? (1 -> kyllä, 2 -> ei) ");
            int action = Integer.parseInt(input.nextLine());
            
            if (action == 1) {
                addIndex(conn);
            } else {
                System.out.println("Nyt kestää, älä pidätä hengitystä.");
            }
            
            startTime = System.nanoTime(); 
            for (int i=0; i<1000; i++) {
                PreparedStatement p = conn.prepareStatement(
                    "SELECT COUNT(*) määrä FROM Elokuvat Where vuosi=?;"
                );
              
                int randYear = randYear(1900,2000);
                p.setInt(1, randYear);
                p.executeQuery();
            }
            endTime = System.nanoTime();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Kysely kestää:");
        System.out.println((endTime-startTime)/1000000000);
    }

    private static void order66(Statement statement) {
        try {
            statement.execute("DROP TABLE Elokuvat;");
            System.out.println("Order 66 successfull");
          } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
    }
}