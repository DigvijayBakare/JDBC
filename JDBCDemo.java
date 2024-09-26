package JDBC;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver";
//        String url = "jdbc:odbc:XE";

        String driverClassName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/TestDB";
        String username = "postgres";
        String password = "19111011";
        String query = "insert into student values(109, 'bhatt')";

        // Load driver class
        Class.forName(driverClassName);

        // Obtain a connection
        Connection con = DriverManager.getConnection(
                url, username, password);

        // Obtain a statement
        Statement st = con.createStatement();

        // Execute the query
        int count = st.executeUpdate(query);
        System.out.println(
                "number of rows affected by this query= "
                        + count);

        // Closing the connection as per the
        // requirement with connection is completed
        con.close();
    }
}
