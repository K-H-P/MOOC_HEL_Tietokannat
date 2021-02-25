import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 


public class testi {
    
    private static final String CREATE_TABLE="CREATE TABLE Elokuvat ("
    + "id INT NOT NULL,"
    + "nimi VARCHAR(20) NOT NULL,"
    + "vuosi INT NOT NULL,"
    + "PRIMARY KEY (id))";

    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            
            conn = DriverManager.getConnection("jdbc:sqlite:testi.db");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            
            statement.executeUpdate(CREATE_TABLE);
            System.out.println("Taulu luotu");



            /*Scanner input = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("Valitse toiminto 1 - 3 testejä varten ja 4 lopettaaksesi ohjelman: ");
                    int action = Integer.parseInt(input.nextLine());
        
                    if (action == 4) {
                    System.exit(0);
                    input.close();
                    } else if (action == 1) {
                        function1(conn);
                    } else if (action == 2) {
                        function2(conn);
                    } else if (action == 3) {
                        function3(conn);
                    } else {
                    System.out.println("Kyseistä toimintoa ei ole olemassa.");
                    }
  
                }
                catch (NumberFormatException e) {
                    System.out.println("Kyseistä toimintoa ei ole olemassa.");
                }
            }*/
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
