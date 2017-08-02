package com.metacube.controllers;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import com.metacube.main.Home;
import com.metacube.main.ReadCsv;
import com.metacube.models.*;
import com.metacube.utility.Util;

/**
 * Class Holds all Posts and Provide the function to do operation on that.
 * @author Rahul Kumar
 *
 */
public class Posts {
	final static String IMPORT_POSTS_FILE = "src/post.csv";
	static HashMap<String,Post> totalPosts = new HashMap<>();
	
	/**
	 * method return All Posts
	 * @return
	 */
	public HashMap<String, Post> getPosts(){
		// getter method
		return totalPosts;
	}
	
	/**
	 * Empty Posts Class Constructor
	 */
	public Posts() {
		
	}
	
	/**
	 * Method reads the Posts from CSV File
	 */
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
	
	/**
	 * Method shows all Posts
	 */
	public void showPosts() {
		boolean hasPosts = false;
		System.out.println("Posts : ");
		Users user = new Users();
		
		for (String key : totalPosts.keySet()) {
			System.out.println("ID : " + totalPosts.get(key).getPostId() + "\n Posted By : " + user.getUserById(totalPosts.get(key).getPostCreator()).getUserName() + " \n Description : " + totalPosts.get(key).getPostText() + "\n Created On : " + totalPosts.get(key).getPostCreationDate());
			System.out.println("------------------------------------------------------------------------");
			hasPosts = true;
		}
		
		if (hasPosts == false) {
			System.out.println("There is no Posts");
		}
	}
	
	/**
	 * Method shows post of a specific user
	 * @param id
	 */
	public void showPostsById(String id) {
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
	
	/**
	 * Method deletes a Post
	 */
	public void deletePost() {
		String keyForRemove = "";
		int removePostWithId = 0;
		
		while(true) {
			try {
				System.out.println("Enter Post ID");
				removePostWithId = Util.sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please Enter a Valid ID");
				Util.sc.nextLine();
			}
		}
		
		for (String key : totalPosts.keySet()) {
			if((Home.sessionId+"").equals(totalPosts.get(key).getPostCreator() )
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
	
	/**
	 * Method add a Post
	 */
	public void addPost() {
		String newPost = "";
		int max = 0;
		
		System.out.println("Enter Your Post : ");
		Util.sc.nextLine();
		newPost = Util.sc.nextLine();
	
		Date date = new Date();
        
        for (String key : totalPosts.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		Post post = new Post();
		post.setPost(max+"", Home.sessionId+"", newPost, Util.formateDate().format(date)+"");
		totalPosts.put(max+"", post);
		
		System.out.println("Post Created!!");
		
	}
	
}
