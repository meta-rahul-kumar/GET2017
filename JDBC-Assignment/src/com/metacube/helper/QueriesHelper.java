package com.metacube.helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.metacube.dao.ConnectionDAO;
import com.metacube.model.Title;

public class QueriesHelper {
	
	public void checkIssueStatus() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String bookName = "";
		int memberId;
		ConnectionDAO connectionDAO = new ConnectionDAO();
		
		System.out.println("Enter Book Name");
		bookName = sc.nextLine();
		
		System.out.println("Enter Member ID");
		while(!sc.hasNextInt()) {
			System.out.println("Please Enter a Valid Number");
		}
		memberId = sc.nextInt();
		
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB().prepareStatement("SELECT * FROM book_issue AS BI\n" + 
				"INNER JOIN books AS B ON B.accession_no = BI.accession_no\n" + 
				"INNER JOIN titles AS T ON B.title_id = T.title_id\n" + 
				"INNER JOIN members AS M ON M.member_id = BI.member_id\n" + 
				"WHERE T.title_name = ? AND M.member_id = ?");
		stmt.setString(1, bookName);
		stmt.setInt(2, memberId);
		
		System.out.println(connectionDAO.checkIssueStatus(stmt));
	}
	
	public void deleteBooks() throws SQLException {
		ConnectionDAO connectionDAO = new ConnectionDAO();
		
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB().prepareStatement("DELETE FROM books\n" + 
				"WHERE accession_no NOT IN (SELECT BI.accession_no\n" + 
				"                            FROM book_issue AS BI\n" + 
				"                            WHERE  TIMESTAMPDIFF(YEAR,BI.issue_dt,NOW()) < 1)");
		System.out.println("Total Books Deleted : " + connectionDAO.deleteBooks(stmt));
	}
	
	public void getBooksDataByAuthorName() throws SQLException {
		ConnectionDAO connectionDAO = new ConnectionDAO();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String authorName = "";
		System.out.println("Enter Author Names");
		authorName = sc.nextLine();
		
		@SuppressWarnings("static-access")
		PreparedStatement stmt = ConnectionManager.getInstance().connectToDB().prepareStatement("SELECT T.title_id , T.title_name\n" + 
				"FROM authors AS A\n" + 
				"INNER JOIN title_author AS TA ON A.author_id = TA.author_id\n" + 
				"INNER JOIN titles AS T ON T.title_id = TA.title_id\n" + 
				"WHERE A.author_nm = ?");
		stmt.setString(1, authorName);
		ResultSet result = connectionDAO.getBooksDataByAuthorName(stmt);
		ArrayList<Title> resultTitles = new ArrayList<>();
		while (result.next()) {
			Title title = new Title();
			title.setTitleId(Integer.parseInt(result.getString(1)));
			title.setTitleName(result.getString(2));
			resultTitles.add(title);
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("Title ID\tTitle");
		System.out.println("------------------------------------------------");
		for (Title key : resultTitles) {
			System.out.println(key.getTitleId() + "\t\t" + key.getTitleName());
		}

		System.out.println("------------------------------------------------");
	}
}
