package JDBC;

import java.sql.*;
import java.io.*;

public class FullDynamicInsertionJDBC {
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
            String i = "insert into NewTable(name,surname) values(?, ?)";

            // create a Prepared statement
            PreparedStatement PreSta = con.prepareStatement(i);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name: ");
            String name = br.readLine();
            System.out.println("Enter surname: ");
            String surname = br.readLine();

            // insert data into table
            PreSta.setString(1, name);
            PreSta.setString(2, surname);

            PreSta.executeUpdate();
            System.out.println("Value inserted into the table..");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
