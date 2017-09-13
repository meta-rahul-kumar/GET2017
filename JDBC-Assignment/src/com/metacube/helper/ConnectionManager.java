package com.metacube.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static ConnectionManager connectionCreator = null;
	
	public static ConnectionManager getInstance() {
		if (connectionCreator == null) {
			synchronized (ConnectionManager.class) {
				if (connectionCreator == null) {
					connectionCreator = new ConnectionManager();
				}
			}
		}
		
		return connectionCreator;
	}
	
	public static Connection connectToDB() throws SQLException{
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "lis";
		String mysqlURL = host + dbName;
		String userId = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException cnfe) {
			 System.out.println("Error Loading driver" + cnfe);
		}
		
		Connection connection = DriverManager.getConnection(mysqlURL, userId, password);
		return connection;
	}
}
