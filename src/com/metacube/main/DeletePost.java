package com.metacube.main;
import com.metacube.controllers.Posts;

/**
 * Class Deletes a Post
 * @author User17
 *
 */
public class DeletePost implements Action {

	/**
	 * method - performAction 
	 * method deletes a Post
	 */
	@Override
	public void performAction() {
		Posts posts = new Posts();
		posts.deletePost();
	}

}
