package com.metacube.main;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import com.metacube.controllers.Connections;
import com.metacube.controllers.OrganisationFollowers;
import com.metacube.controllers.Organisations;
import com.metacube.controllers.Posts;
import com.metacube.controllers.Users;
import com.metacube.utility.Util;

public class Home {
	public static int sessionId = 0;
	final static String IMPORT_CONNECTION_FILE = "src/connection.csv";
	final static String IMPORT_ORGANISATION_FILE = "src/organisation.csv";
	
	/**
	 * Method - authenticateUser
	 * method checks that a user exists or not
	 * @param name
	 * @return
	 */
	public static boolean authenticateUser(String name) {
		Users users = new Users();
		return users.authenticateUserByName(name);
	}
	
	
	/**
	 * method - createMenu
	 * creates Menu and Sub Menus
	 * @return
	 */
	public  static Menu createMenu(){
		Menu mainMenu = new Menu();
		
		MenuItem mi = new ActionableMenuItem(new Util());
		List<MenuItem> subMenu = mainMenu.getSubMenu();
		mi = new Menu();
		mi.setDisplayName("1. Friends");
		subMenu.add(mi);
		
		List<MenuItem> friendsSubMenu = ((Menu) mi).getSubMenu();
        
		mi = new ActionableMenuItem(new AddFriend());
        mi.setDisplayName("1. Add Friend");
        friendsSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new ViewFriends());
        mi.setDisplayName("2. View Friends");
        friendsSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new RemoveFriend());
        mi.setDisplayName("3. Remove Friend");
        friendsSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new ShowMainMenu());
        mi.setDisplayName("4. Back");
        friendsSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new Logout());
        mi.setDisplayName("5. Logout");
        friendsSubMenu.add(mi);
        
		mi = new Menu();
		mi.setDisplayName("2. Organisation");
		subMenu.add(mi);
		
		List<MenuItem> organisationSubMenu = ((Menu) mi).getSubMenu();
		
        mi = new ActionableMenuItem(new CreateOrganisation());
        mi.setDisplayName("1. Create Organisation");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new DeleteOrganisation());
        mi.setDisplayName("2. Delete Organisation");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new FollowOrganisation());
        mi.setDisplayName("3. Follow Organisation");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new UnfollowOrganisation());
        mi.setDisplayName("4. UnFollow Organisation");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new FollowedOrganisation());
        mi.setDisplayName("5. View Followed Organisations");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new FriendFollowedOrganisation());
        mi.setDisplayName("6. View Friend Followed Organisations");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new ShowMainMenu());
        mi.setDisplayName("7. Back");
        organisationSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new Logout());
        mi.setDisplayName("8. Logout");
        organisationSubMenu.add(mi);
        
        mi = new Menu();
		mi.setDisplayName("3. Post");
		subMenu.add(mi);
		
		List<MenuItem> postSubMenu = ((Menu) mi).getSubMenu();
		
        mi = new ActionableMenuItem(new CreatePost());
        mi.setDisplayName("1. Post Something");
        postSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new DeletePost());
        mi.setDisplayName("2. Delete Post");
        postSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new ViewPosts());
        mi.setDisplayName("3. View Your Posts");
        postSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new ViewFriendPosts());
        mi.setDisplayName("4. View Friend Posts");
        postSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new ShowMainMenu());
        mi.setDisplayName("5. Back");
        postSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new Logout());
        mi.setDisplayName("6. Logout");
        postSubMenu.add(mi);
        
        mi = new ActionableMenuItem(new SearchUser());
        mi.setDisplayName("4. Search");
        subMenu.add(mi);
		
		mi = new ActionableMenuItem(new Logout());
		mi.setDisplayName("5.Logout");
		subMenu.add(mi);
		
		return mainMenu;
		
	}
	
	/**
	 * method - display
	 * Display Menu
	 * @param menu
	 */
	public static void display(Menu menu){
		
		Iterator<MenuItem> itr = menu.getSubMenu().iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
		
		
	}
	
	/**
	 * method - getInput
	 * takes an choice for menu and sub menus
	 * @return
	 */
	public static int getInput(){
		int choice = 0;
		while(true) {
		    try
		    {
		    	System.out.println("Enter Your Choice");
				choice = Util.sc.nextInt();
				break;
		    } 
		    catch (InputMismatchException y)
		    {
			    System.out.println("Please Enter a Valid Choice");
			    Util.sc.nextLine();

		    }  
		}  

		return choice-1;
	}
	
	/**
	 * method - displayAndPerformAction
	 * method display and performs the action on selected menu item
	 * @param menu
	 */
	public static void displayAndPerformAction(Menu menu){
		
		display(menu);
		
		int choice = getInput();
		
		MenuItem menuItem = menu.getSelection(choice);
	
		
		if(menuItem == null){
			displayAndPerformAction(menu);
		}
		else if(menuItem instanceof ActionableMenuItem) {
			
			((ActionableMenuItem)menuItem).triggerAction();
			
		}
		else{
			displayAndPerformAction((Menu)menuItem);
		}
	}
	
	/**
	 * Method reads all CSV Files
	 */
	private static void initNetwork() {
		Connections connections = new Connections();
		connections.initConnections();
		Organisations organisations = new Organisations();
		organisations.initOrganisations();
		Posts posts = new Posts();
		posts.initPosts();
		OrganisationFollowers organisationFollowers = new OrganisationFollowers();
		organisationFollowers.initFollowers();
		
	}
	
	/**
	 * Method shows welocome page and Login and Signup
	 */
	public static void homePageWork() {
		String name = new String();
		Menu menu = createMenu();
		System.out.println("1. Login");
		System.out.println("2. SignUp");
		int choice = 0;
		
		Users users = new Users();
		users.initUsers();
		
		while(choice != 1 && choice != 2) {
			while(true){
				try {
					System.out.println("Choose from menu");
					if(Util.InputErrorcounter != 0) {
						Util.sc.nextLine();
					}
					choice = Util.sc.nextInt();
					Util.InputErrorcounter = 0;
					break;
				} catch (Exception e) {
					System.out.println("Please Enter a Valid Choice"); 
					Util.InputErrorcounter++;
				}
			}
				
				switch (choice) {
				case 1: 
					while(true) {
						
						System.out.println("Enter Your Login Name");
						if(Util.InputErrorcounter == 0) {
							Util.sc.nextLine();
						}
						name = Util.sc.nextLine();
						
						if(!authenticateUser(name)) {
							System.out.println("Wrong Login Detail.. Try Again");
							Util.InputErrorcounter++;
						}else {
							Util.InputErrorcounter = 0;
							break;
						}
					}
					Util.setSessionId(name); // set the session for current logged in User
					
					System.out.println("Successfully Logged In.");
					break;
				case 2:
					users.addUser();
					break;
				default:
					System.out.println("Please Enter a Valid Choice");
					break;
				}
		}

		
		
		initNetwork();  // read connection,follower,organisation,post files and initialize the network
		
		
		
		while (true) {
			displayAndPerformAction(menu);
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println("Welcome in MetaBook");
		homePageWork();
	}
}
