package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FirstJDBC {
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

            // Create query for creating a table
            String q = "create table FirstTable(id int primary key, name varchar(50) not null)";

            // create a statement
            Statement sta = con.createStatement();
            sta.executeUpdate(q);
            System.out.println("Table created in the database!!");

            // close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
