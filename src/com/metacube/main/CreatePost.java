package com.metacube.main;
import com.metacube.controllers.Posts;

/**
 * Class Creates a Post
 * @author Rahul Kumar
 *
 */
public class CreatePost implements Action {

	/**
	 * method - performAction 
	 * method creates a Post
	 */
	@Override
	public void performAction() {
		Posts posts = new Posts();
		posts.addPost();
	}

}
