package com.metacube.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionManager class establish the connection from mySQL
 * 
 * @author Rahul Kumar
 *
 */
public class ConnectionManager {
	public static ConnectionManager connectionCreator = null;

	/**
	 * Singleton Global Access Method
	 * 
	 * @return
	 */
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

	/**
	 * Establish the connection to mySQL using JDBC Driver
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection connectToDB() throws SQLException {
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "lis";
		String mysqlURL = host + dbName;
		String userId = "root";
		String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error Loading driver" + cnfe);
		}

		Connection connection = DriverManager.getConnection(mysqlURL, userId, password);
		return connection;
	}
}
