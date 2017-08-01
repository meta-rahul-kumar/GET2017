
public class ViewFriendPosts implements Action {

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
