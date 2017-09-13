package com.metacube.test;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.metacube.dao.ConnectionDAO;
import com.metacube.helper.ConnectionManager;

/**
 * Test Class For ConnectionDAO Class Methods
 * 
 * @author Rahul Kumar
 *
 */
public class ConnectionDAOTest {

	@Test
	public void executeQueryTest_IsBookIssue_True() throws SQLException {
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT * FROM book_issue AS BI\n"
						+ "INNER JOIN books AS B ON B.accession_no = BI.accession_no\n"
						+ "INNER JOIN titles AS T ON B.title_id = T.title_id\n"
						+ "INNER JOIN members AS M ON M.member_id = BI.member_id\n"
						+ "WHERE T.title_name = ? AND M.member_id = ?");
		stmt.setString(1, "A handbook to Analog Electronics");
		stmt.setInt(2, 3);
		ConnectionDAO connectionDAO = new ConnectionDAO();
		boolean expected = true;
		boolean actual = false;
		int size = 0;
		ResultSet resultSet = connectionDAO.executeQuery(stmt);
		if (resultSet != null) {
			resultSet.beforeFirst();
			resultSet.last();
			size = resultSet.getRow();
		}
		
		if(size > 0) {
			actual = true;
		}

		assertEquals(expected, actual);
	}

	@Test
	public void executeQueryTest_IsBookIssue_False() throws SQLException {
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT * FROM book_issue AS BI\n"
						+ "INNER JOIN books AS B ON B.accession_no = BI.accession_no\n"
						+ "INNER JOIN titles AS T ON B.title_id = T.title_id\n"
						+ "INNER JOIN members AS M ON M.member_id = BI.member_id\n"
						+ "WHERE T.title_name = ? AND M.member_id = ?");
		stmt.setString(1, "A handbook to Analog Electronics");
		stmt.setInt(2, 4);
		ConnectionDAO connectionDAO = new ConnectionDAO();
		boolean expected = true;
		boolean actual = false;
		int size = 0;
		ResultSet resultSet = connectionDAO.executeQuery(stmt);
		if (resultSet != null) {
			resultSet.beforeFirst();
			resultSet.last();
			size = resultSet.getRow();
		}
		
		if(size > 0) {
			actual = true;
		}

		assertNotEquals(expected, actual);
	}

	@Test(expected = SQLException.class)
	public void executeQueryTest_True_Exception() throws SQLException {
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT * FROM book_issue AS BI\n"
						+ "INNER JOIN books AS B ON B.accession_no = BI.accession_no\n"
						+ "INNER JOIN titles AS T ON B.title_id = T.title_id\n"
						+ "INNER JOIN members AS M ON M.member_id = BI.member_id\n" + "WHERE T.title_name = ? AND");
		stmt.setString(1, "A handbook to Analog Electronics");
		stmt.setInt(2, 3);
		ConnectionDAO connectionDAO = new ConnectionDAO();
		boolean expected = true;

		assertEquals(expected, connectionDAO.executeQuery(stmt));
	}

	@Test
	public void deleteBooksTest_True() throws SQLException {
		ConnectionDAO connectionDAO = new ConnectionDAO();

		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("DELETE FROM books\n" + "WHERE accession_no NOT IN (SELECT BI.accession_no\n"
						+ "                            FROM book_issue AS BI\n"
						+ "                            WHERE  TIMESTAMPDIFF(YEAR,BI.issue_dt,NOW()) < 1)");
		int expected = 4;

		assertEquals(expected, connectionDAO.deleteBooks(stmt));
	}

	@Test
	public void deleteBooksTest_False() throws SQLException {
		ConnectionDAO connectionDAO = new ConnectionDAO();

		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("DELETE FROM books\n" + "WHERE accession_no NOT IN (SELECT BI.accession_no\n"
						+ "                            FROM book_issue AS BI\n"
						+ "                            WHERE  TIMESTAMPDIFF(YEAR,BI.issue_dt,NOW()) < 1)");
		int expected = 15;

		assertNotEquals(expected, connectionDAO.deleteBooks(stmt));
	}

	@Test
	public void executeQueryTest_getBooksTitlesByAuthorName_True() throws SQLException {
		ConnectionDAO connectionDAO = new ConnectionDAO();

		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT T.title_id , T.title_name\n" + "FROM authors AS A\n"
						+ "INNER JOIN title_author AS TA ON A.author_id = TA.author_id\n"
						+ "INNER JOIN titles AS T ON T.title_id = TA.title_id\n" + "WHERE A.author_nm = ?");
		stmt.setString(1, "Sudesh Garg");

		String expected = "Complete Reference to Structure Planning";
		ResultSet result = connectionDAO.executeQuery(stmt);
		result.next();
		assertEquals(expected, result.getString(2));
	}

	@Test
	public void executeQueryTest_getBooksTitlesByAuthorName_False() throws SQLException {
		ConnectionDAO connectionDAO = new ConnectionDAO();

		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT T.title_id , T.title_name\n" + "FROM authors AS A\n"
						+ "INNER JOIN title_author AS TA ON A.author_id = TA.author_id\n"
						+ "INNER JOIN titles AS T ON T.title_id = TA.title_id\n" + "WHERE A.author_nm = ?");
		stmt.setString(1, "Sudesh Garg");

		String expected = "Let Us C";
		ResultSet result = connectionDAO.executeQuery(stmt);
		result.next();
		assertNotEquals(expected, result.getString(2));
	}
}
