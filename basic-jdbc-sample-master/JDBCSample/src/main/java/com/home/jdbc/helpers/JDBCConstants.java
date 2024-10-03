package com.home.jdbc.helpers;

/**
 * Change the driver,url,username and password according to your needs
 * 
 * @author preetham
 */
public class JDBCConstants
{
   /*public static final String DRIVER_NAME = "org.hsqldb.jdbc.JDBCDriver";
   public static final String URL         = "jdbc:hsqldb:hsql://localhost/";
   public static final String USERNAME    = "sa";
   public static final String PASSWORD    = "";*/

   public static final String DRIVER_NAME = "org.postgresql.Driver";
   public static final String URL         = "jdbc:postgresql://localhost:5432/TestDB";
   public static final String USERNAME    = "postgres";
   public static final String PASSWORD    = "19111011";
}
