
public class Post {
	String postId;
	String postCreator;
	String postText;
	String postCreatedDate;
	public void setPost(String id, String creator,
			String text, String date) {
		this.postId = id;
		this.postCreator = creator;
		this.postText = text;
		this.postCreatedDate = date;
		
	}
	
	String getPostId() {
		return postId;
	}
	
	String getPostCreator() {
		return postCreator;
	}
	
	String getPostText() {
		return postText;
	}
	
	String getPostCreationDate() {
		return postCreatedDate;
	}
}
