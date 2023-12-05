package carsharing;

import org.h2.tools.DeleteDbFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
        Statement stmt;
        String DBName = args.length > 0 ? args[1] : "carsharing";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:./src/carsharing/db/" + DBName)) {

            stmt = conn.createStatement();
            String sql =  """
                    CREATE TABLE COMPANY (
                    ID INTEGER not NULL, 
                    NAME VARCHAR_IGNORECASE(255),
                    PRIMARY KEY ( id ))
                     """;
            DeleteDbFiles.execute("./src/carsharing/db", "carsharing", true);
            stmt.executeUpdate(sql);
            conn.setAutoCommit(true);
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
