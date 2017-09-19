package com.metacube.main;
import com.metacube.controllers.Users;
import com.metacube.utility.Util;

/**
 * class search users
 * @author User17
 *
 */
public class SearchUser implements Action {

	/**
	 * method search users
	 */
	@Override
	public void performAction() {
		String search="";
		Users users = new Users();
		
		System.out.println("Search User : ");
		search = Util.sc.next();
		users.searchUser(search);
		

	}

}
