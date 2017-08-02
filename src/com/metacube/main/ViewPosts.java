package com.metacube.main;
import com.metacube.controllers.Posts;

/**
 * Class displays the posts of user
 * @author Rahul Kumar
 *
 */
public class ViewPosts implements Action {

	/**
	 * Method displays the posts of user
	 */
	@Override
	public void performAction() {
		Posts posts = new Posts();
		posts.showPostsById(Home.sessionId+"");
	}

}
