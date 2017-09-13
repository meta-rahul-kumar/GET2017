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
	 * checks that book is issued by member or not
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public boolean checkIssueStatus(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();

		int size = 0;
		if (rs != null) {
			rs.beforeFirst();
			rs.last();
			size = rs.getRow();
		}

		boolean status = false;
		if (size > 0) {
			status = true;
		}
		return status;
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

	/**
	 * get the book title and title id which is written by given author
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getBooksDataByAuthorName(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();
		return rs;
	}

}
