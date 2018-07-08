package com.game.swingy.core.DataBase;

//STEP 1. Import required packages
import java.sql.*;

public class DbMySQL {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    public DbMySQL() {
        runSql();
    }

    public void runSql() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS Swingy";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
            conn.setCatalog("Swingy");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS Unit" +
                    "(id INT UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    " unitType VARCHAR(5) NOT NULL, " +
                    " name VARCHAR(30) NOT NULL, " +
                    " heroClass VARCHAR(8) NOT NULL, " +
                    " level TINYINT UNSIGNED NOT NULL, " +
                    " attack SMALLINT  UNSIGNED NOT NULL, " +
                    " defense SMALLINT UNSIGNED NOT NULL, " +
                    " hitPoints SMALLINT UNSIGNED NOT NULL, " +
                    " weapon SMALLINT UNSIGNED NOT NULL, " +
                    " armor SMALLINT UNSIGNED NOT NULL, " +
                    " helm SMALLINT UNSIGNED NOT NULL, " +
                    " coordinatesX TINYINT UNSIGNED NOT NULL, " +
                    " coordinatesY TINYINT UNSIGNED NOT NULL, " +
                    " experience TINYINT UNSIGNED, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Map" +
                    "(heroId INT UNSIGNED NOT NULL, " +
                    "villainId INT UNSIGNED NOT NULL, " +
                    "PRIMARY KEY (heroId , villainId), " +
                    "FOREIGN KEY (heroId) REFERENCES Unit(id), " +
                    "FOREIGN KEY (villainId ) REFERENCES Unit(id) )";
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample
