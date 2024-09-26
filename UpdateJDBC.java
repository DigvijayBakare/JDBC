package JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateJDBC {
    private static Connection con;
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/TestDB";
        String username = "postgres";
        String password = "19111011";

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
    public static void main(String[] args) throws Exception {
        Connection con = getConnection();

        String q = "update firstTable set name = ? where id = ?";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter new name: ");
        String name = br.readLine();

        System.out.println("Enter id number: ");
        int id = Integer.parseInt(br.readLine());

        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Name updated...");

        con.close();
    }
}
