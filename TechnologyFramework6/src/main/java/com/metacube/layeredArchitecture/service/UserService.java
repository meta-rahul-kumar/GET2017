package main.java.com.metacube.layeredArchitecture.service;

import main.java.com.metacube.layeredArchitecture.model.User;

public interface UserService {
	public User checkLogin(String name, String password);
}
