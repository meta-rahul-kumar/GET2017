
public class ViewPosts implements Action {

	@Override
	public void performAction() {
		Posts posts = new Posts();
		posts.showPostsById(Users.sessionId+"");
	}

}
