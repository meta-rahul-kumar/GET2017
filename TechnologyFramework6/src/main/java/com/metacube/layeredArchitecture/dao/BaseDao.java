package main.java.com.metacube.layeredArchitecture.dao;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.model.BaseModel;

public interface BaseDao<T extends BaseModel> {
	T getById(int id);
	int deleteById(int id);
	List<T> getAll();
	void delete(T t);
	int create(T t);
	void update(T t, int id);
}