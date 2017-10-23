package main.java.com.metacube.layeredArchitecture.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.java.com.metacube.layeredArchitecture.model.User;
import main.java.com.metacube.layeredArchitecture.service.UserService;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
	@Autowired
	UserService userService;

	public DefaultUserFacade() {

	}

	public DefaultUserFacade(UserService userService) {
		this.userService = userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Override
	public User check(String name, String password) {
		return userService.checkLogin(name, password);
	}
}