package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by G710 on 25.03.2017.
 */
public class DbConnection {
    public static Connection connection;

    private static volatile DbConnection instance;
    private DbConnection(){}

    public static DbConnection getInstance(){
        DbConnection localInstance = instance;
        if (localInstance == null){
            synchronized (DbConnection.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new DbConnection();
                }
            }
        }
        return localInstance;
    }

    public void connectionDb(){
        connection = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:DataBase//local_nets_db.db");
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
