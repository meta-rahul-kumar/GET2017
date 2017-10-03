package main.java.com.metacube.layeredArchitecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.com.metacube.layeredArchitecture.model.BaseModel;

public abstract class GenericJdbcDao<T extends BaseModel> implements BaseDao<T> {
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
	
	protected abstract String getTableName();
	protected abstract T getProduct(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();
	
	public T getById(int primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery
					("SELECT * FROM " 
							+ getTableName() 
							+ " where " + getPrimaryKeyColoumnName() 
							+" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return getProduct(resultSet);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public int deleteById(int primaryKey) {
		int affectedRows = 0;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			affectedRows = stmt.executeUpdate
					("DELETE FROM " 
							+ getTableName() 
							+ " where " + getPrimaryKeyColoumnName() 
							+" = '" + primaryKey + "'");
		} catch (Exception e) {
			
		}
		return affectedRows;
	}
	
	public List<T> getAll ()
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> productList = new ArrayList<>();
			while(resultSet.next()) {
				productList.add(getProduct(resultSet));
			}
			return productList;

		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	public void create(T t) {
		
	}
	
	public void delete(T t) {
		
	}
	
	public void update(T t) {
		
	}
}