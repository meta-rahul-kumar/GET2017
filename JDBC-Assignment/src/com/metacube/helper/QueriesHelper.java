package com.metacube.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * QueriesHelper class creates the query and call the connectionDAO methods
 * 
 * @author Rahul Kumar
 *
 */
public class QueriesHelper {

	/**
	 * checks that book is issued by member or not
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public ResultSet isBookIssued(String bookName, int memberId) throws SQLException {
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT M.member_name FROM book_issue AS BI\n"
						+ "INNER JOIN books AS B ON B.accession_no = BI.accession_no\n"
						+ "INNER JOIN titles AS T ON B.title_id = T.title_id\n"
						+ "INNER JOIN members AS M ON M.member_id = BI.member_id\n"
						+ "WHERE T.title_name = ? AND M.member_id = ?");
		stmt.setString(1, bookName);
		stmt.setInt(2, memberId);

		return ConnectionManager.getInstance().executeQuery(stmt);
	}

	/**
	 * deletes all the books which are not issued from 1 year
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public int deleteBooks() throws SQLException {

		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("DELETE FROM books\n" + "WHERE accession_no NOT IN (SELECT BI.accession_no\n"
						+ "                            FROM book_issue AS BI\n"
						+ "                            WHERE  TIMESTAMPDIFF(YEAR,BI.issue_dt,NOW()) < 1)");
		return ConnectionManager.getInstance().deleteBooks(stmt);
	}

	/**
	 * get the book title and title id which is written by given author
	 * 
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getBooksTitlesByAuthorName(String authorName) throws SQLException {
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB()
				.prepareStatement("SELECT T.title_id , T.title_name\n" + "FROM authors AS A\n"
						+ "INNER JOIN title_author AS TA ON A.author_id = TA.author_id\n"
						+ "INNER JOIN titles AS T ON T.title_id = TA.title_id\n" + "WHERE A.author_nm = ?");
		stmt.setString(1, authorName);
		return ConnectionManager.getInstance().executeQuery(stmt);
	}
}
