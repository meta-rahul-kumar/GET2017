package main.java.com.metacube.layeredArchitecture.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import main.java.com.metacube.layeredArchitecture.dao.user.UserDao;
import main.java.com.metacube.layeredArchitecture.model.User;

@Component("userService")
@Transactional
public class DefaultUserService implements UserService {

	@Resource(name = "hibernateUserDao")
	UserDao userDao;

	@Override
	public User checkLogin(String name, String password) {
		return userDao.checkAuth(name, password);
	}
}