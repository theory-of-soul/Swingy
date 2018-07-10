package com.game.swingy.core.DataBase;

//STEP 1. Import required packages
import com.game.swingy.core.Unit.Hero.Hero;
import com.game.swingy.core.Unit.Unit;

import java.sql.*;

public class DbMySQL {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    private Connection conn;
    private Statement statement;

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    private String dbName = "Swingy";

    int heroId;

    public DbMySQL() {//2817654 ніна Олексан
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            createDataBase();
            createTables();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDataBase() {

        try {
            //Execute a query
            System.out.println("Creating database...");
            statement = conn.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");

            //Open a connection
            System.out.println("Connecting to database...");
            conn.setCatalog(dbName);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {

        String hero;
        String villain;

        hero = "CREATE TABLE IF NOT EXISTS Hero" +
                "(id INT UNSIGNED NOT NULL AUTO_INCREMENT, " +
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
                " experience TINYINT UNSIGNED NOT NULL, " +
                " PRIMARY KEY ( id ))";

        villain = "CREATE TABLE IF NOT EXISTS Villain" +
                "(id INT UNSIGNED NOT NULL AUTO_INCREMENT, " +
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
                " heroId INT UNSIGNED NOT NULL, " +
                " PRIMARY KEY ( id ), " +
                " FOREIGN KEY (heroId) REFERENCES Hero(id))";
        /*Map = "CREATE TABLE IF NOT EXISTS Map" +
                "(heroId INT UNSIGNED NOT NULL, " +
                "villainId INT UNSIGNED NOT NULL, " +
                "PRIMARY KEY (heroId , villainId), " +
                "FOREIGN KEY (heroId) REFERENCES Unit(id), " +
                "FOREIGN KEY (villainId ) REFERENCES Unit(id) )";*/

        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Execute a query
            System.out.println("Creating table in given database...");
            statement = conn.createStatement();

            statement.executeUpdate(hero);
            statement.executeUpdate(villain);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } /*finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try*/
    }
    public void fillUnitTable(Unit unit) {

        String query;
        if (unit instanceof Hero)
            query = "INSERT INTO Hero (name, heroClass, level, attack, " +
                    "defense, hitPoints, weapon, armor, helm, coordinatesX, " +
                    "coordinatesY, experience) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        else
            query = "INSERT INTO Villain (name, heroClass, level, attack, " +
                    "defense, hitPoints, weapon, armor, helm, coordinatesX, " +
                    "coordinatesY, heroId) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Execute a query
            System.out.println("Fill Unit table in Swingy database...");
            statement = conn.createStatement();

            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, unit.getName());
            preparedStatement.setString(2, unit.getHeroClass());
            preparedStatement.setInt(3, unit.getLevel());
            preparedStatement.setInt(4, unit.getAttack());
            preparedStatement.setInt(5, unit.getDefense());
            preparedStatement.setInt(6, unit.getHitPoints());
            preparedStatement.setInt(7, unit.getArtefacts().getWeapon());
            preparedStatement.setInt(8, unit.getArtefacts().getArmor());
            preparedStatement.setInt(9, unit.getArtefacts().getHelm());
            preparedStatement.setInt(10, unit.getCoordinates().getX());
            preparedStatement.setInt(11, unit.getCoordinates().getY());
            if (unit instanceof Hero) {
                preparedStatement.setInt(12, ((Hero) unit).getExperience());
                preparedStatement.execute();
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next())
                        heroId = rs.getInt(1);
                }
            }
            else {
                preparedStatement.setInt(12, heroId);
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } /*finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try*/
    }
    public void fillMapTable() {

    }
}