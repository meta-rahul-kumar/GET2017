package com.metacube.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDAO {

	public boolean checkIssueStatus(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();
		
		int size= 0;
		if (rs != null)   
		{  
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

	public int deleteBooks(PreparedStatement stmt) throws SQLException {
		return stmt.executeUpdate(); 
	}

	public ResultSet getBooksDataByAuthorName(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();	
		return rs;
	}

}
