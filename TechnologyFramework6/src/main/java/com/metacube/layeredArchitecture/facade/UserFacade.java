package main.java.com.metacube.layeredArchitecture.facade;

import main.java.com.metacube.layeredArchitecture.model.User;

public interface UserFacade {
	public User check(String name, String password);
}
