package main.java.com.metacube.layeredArchitecture.dao.user;

import main.java.com.metacube.layeredArchitecture.dao.BaseDao;
import main.java.com.metacube.layeredArchitecture.model.User;

public interface UserDao extends BaseDao<User>{
	public User checkAuth(String name, String password);
}