package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJDBC {
    private static Connection con;
    public static Connection getConnection() {
        String url = "jdbc:postgresql://*****:5432/*****";
        String username = "*****";
        String password = "*****";

        try {
            if (con == null) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();

            String q = "select * from customer";
            Statement s = con.createStatement();
            ResultSet set = s.executeQuery(q);

            while (set.next()) {
                int id = set.getInt(1);
                String fName = set.getString(2);
                String lName = set.getString(3);
                System.out.println(id + " : " + fName + " " + lName);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
