
public class DeletePost implements Action {

	@Override
	public void performAction() {
		Posts posts = new Posts();
		posts.deletePost();
	}

}
