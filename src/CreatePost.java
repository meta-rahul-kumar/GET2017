
public class CreatePost implements Action {

	@Override
	public void performAction() {
		Posts posts = new Posts();
		posts.addPost();
	}

}
