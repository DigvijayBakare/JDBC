package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertingData {
    public static void main(String[] args) {
        String driverClassName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/TestDB";
        String username = "postgres";
        String password = "19111011";
        try {
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection closed!");
            } else {
                System.out.println("Connection Established!!");
            }

            // Create query for inserting data in a table
            String q = "insert into FirstTable(id, name) values(1, 'Toni')";

            // create a Prepared statement
            PreparedStatement sta = con.prepareStatement(q);

            sta.executeUpdate();

            System.out.println("Value inserted into the table..");

            // close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
