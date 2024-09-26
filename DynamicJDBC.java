package JDBC;

import java.sql.*;

public class DynamicJDBC {
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
            String q = "create table NewTable(id serial primary key, name varchar(50) not null, surname varchar(50))";

            // create a statement
            Statement sta = con.createStatement();
//            sta.executeUpdate(q);
//            System.out.println("Table created in the database!!");

            // Create query for inserting data in a table
            String i = "insert into NewTable(name,surname) values(?, ?)";

            // create a Prepared statement
            PreparedStatement PreSta = con.prepareStatement(i);

            // insert data into table
//            PreSta.setString(1, "Toni");
//            PreSta.setString(2, "Stark");

            // second row insert
            PreSta.setString(1, "Steve");
            PreSta.setString(2, "Roger");

            PreSta.executeUpdate();
            System.out.println("Value inserted into the table..");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
