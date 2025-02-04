package com.mega_city_cab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
	private static DBConnectionSingleton instance;
    private Connection connection;
    
    private DBConnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mega_city_cab?user=root&password=123321&useSSL=false");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DBConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() {
    	if(connection != null) {
    		try {
    			connection.close();
    		}catch (SQLException e) {
    			e.printStackTrace();
    			
    		}
    	}
    	
    }
}
