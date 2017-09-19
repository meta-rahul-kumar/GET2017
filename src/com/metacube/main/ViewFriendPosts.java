package com.metacube.main;
import com.metacube.controllers.Connections;
import com.metacube.controllers.Posts;
import com.metacube.utility.Util;

/**
 * class displays friends Posts of loggedin user
 * @author Rahul Kumar
 *
 */
public class ViewFriendPosts implements Action {

	/**
	 * method displays friends Posts of loggedin user
	 */
	@Override
	public void performAction() {
		Posts posts = new Posts();
		Connections connections = new Connections();
		int friendId = 0;
		
		
		
		while(true) {
			System.out.println("Enter Friend Id");
			friendId = Util.sc.nextInt();
			if (connections.isConnected(friendId)) {
				posts.showPostsById(friendId+"");
				break;
			}else {
				System.out.println("User with this User id is not your friend");
			}
		}

	}

}
