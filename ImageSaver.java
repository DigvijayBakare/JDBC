package JDBC;

import java.sql.*;
import java.io.*;

public class ImageSaver {
    public static void main(String[] args) {
        String driverClassName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/postgres";
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

            String q = "insert into Image(pic) values(?)";
            PreparedStatement preStat = con.prepareStatement(q);

            FileInputStream fi = new FileInputStream("C:\\Users\\DIGVIJAY\\Pictures\\New folder\\wallpaperflare.com_wallpaper.jpg");
            preStat.setBinaryStream(1, fi, fi.available());
            preStat.executeUpdate();

            System.out.println("Image inserted!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
