import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Posts {
	final static String IMPORT_POSTS_FILE = "src/post.csv";
	static HashMap<String,Post> totalPosts = new HashMap<>();
	
	HashMap<String, Post> getPosts(){
		// getter method
		return totalPosts;
	}
	
	public Posts() {
		
	}
	
	public void initPosts(){
		ReadCsv readCsv = new ReadCsv();
		for(String lineNumber : readCsv.ReadCsvFile(IMPORT_POSTS_FILE)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				Post post = new Post();
				post.setPost(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),tokenizer.nextToken());
				totalPosts.put(post.getPostId(), post);
			}
		}
	}
	
	void showPosts() {
		boolean hasPosts = false;
		System.out.println("Posts : ");
		Users user = new Users();
		
		for (String key : totalPosts.keySet()) {
			System.out.println("ID : " + totalPosts.get(key).getPostId() + "\n Post By : " + user.getUserById(totalPosts.get(key).getPostCreator()).getUserName() + " \n Post : " + totalPosts.get(key).getPostText() + "\n Created On : " + totalPosts.get(key).getPostCreationDate());
			System.out.println("------------------------------------------------------------------------");
			hasPosts = true;
		}
		
		if (hasPosts == false) {
			System.out.println("There is no Posts");
		}
	}
	
	void showPostsById(String id) {
		boolean hasPosts = false;
		Users user = new Users();
		System.out.println("Posts of "+ user.getUserById(id).getUserName() +": ");
		
		for (String key : totalPosts.keySet()) {
			if(id.equals(totalPosts.get(key).getPostCreator())) {
				System.out.println("ID : " + totalPosts.get(key).getPostId() + "\n Post By : " + user.getUserById(totalPosts.get(key).getPostCreator()).getUserName() + " \n Post : " + totalPosts.get(key).getPostText() + "\n Created On : " + totalPosts.get(key).getPostCreationDate());
				System.out.println("------------------------------------------------------------------------");
				hasPosts = true;
			}
		}
		
		if (hasPosts == false) {
			System.out.println("You Posted Nothing.");
		}
	}
	
	void deletePost() {
		System.out.println("Enter Post ID");
		int removePostWithId = 0;
		removePostWithId = Util.sc.nextInt();
		String keyForRemove = "";
		
		for (String key : totalPosts.keySet()) {
			if((Users.sessionId+"").equals(totalPosts.get(key).getPostCreator() )
					&& (removePostWithId+"").equals(totalPosts.get(key).getPostId())) {
				keyForRemove = key;
			}
		}
		
		if (keyForRemove.equals("")) {
			System.out.println("You Can Delete only your posts. It's not your property :)");
		}else {
			totalPosts.remove(keyForRemove);
			System.out.println("Post Deleted with Id " + removePostWithId);
			showPosts();
		}
	}
	
	void addPost() {
		String newPost = "";
		int max = 0;
		
		System.out.println("Enter Your Post : ");
		Util.sc.nextLine();
		newPost = Util.sc.nextLine();
	
		SimpleDateFormat sd = new SimpleDateFormat(
	            "dd-MM-yyyy HH:mm:ss z");
		Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
		
        
        for (String key : totalPosts.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		Post post = new Post();
		post.setPost(max+"", Users.sessionId+"", newPost, sd.format(date)+"");
		totalPosts.put(max+"", post);
		
		System.out.println("Post Created!!");
		
	}
	
}
