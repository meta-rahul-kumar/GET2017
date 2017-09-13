package com.metacube.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ConnectionDAO class performs DB tasks
 * 
 * @author Rahul Kumar
 *
 */
public class ConnectionDAO {

	/**
	 * executes the query
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();
		return rs;
	}

	/**
	 * deletes all the books which are not issued from 1 year
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public int deleteBooks(PreparedStatement stmt) throws SQLException {
		return stmt.executeUpdate();
	}

}
