import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

public class HomeClass {
	final static String IMPORT_CONNECTION_FILE = "src/connection.csv";
	final static String IMPORT_ORGANISATION_FILE = "src/organisation.csv";
	
	public static void showMenu() {
		System.out.println("Lo");
	}
	public static void startingActivity() {
		Users users = new Users();
		users.showUsers();
		users.addUser();
		
		Connections connections = new Connections();
		connections.showConnections();
		connections.addConnection();
//		readCsv.ReadCsvFile(IMPORT_CONNECTION_FILE);
//		readCsv.ReadCsvFile(IMPORT_ORGANISATION_FILE);
	}
	
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
        
        
        mi = new ActionableMenuItem(new Logout());
        mi.setDisplayName("4. Logout");
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
        
        mi = new ActionableMenuItem(new Logout());
        mi.setDisplayName("3. Logout");
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
        
        mi = new ActionableMenuItem(new Logout());
        mi.setDisplayName("5. Logout");
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
			    System.out.println("You must enter a number.");
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
	
	public static void main(String args[]) {
		String name = new String();
		Menu menu = createMenu();
		System.out.println("Welcome in MetaBook");
		System.out.println("1. Login");
		System.out.println("2. SignUp");
		int choice = 0;
		
		Users users = new Users();
		users.initUsers();
		
		
			choice = Util.sc.nextInt();
			
			switch (choice) {
			case 1: 
				break;
			case 2:
				users.addUser();
				break;
			default:
				System.out.println("Please Enter a Valid Choice");
			}
		
		System.out.println("Enter Your Login Name");
		name = Util.sc.nextLine();
		
		
		while(!authenticateUser(name)) {
			System.out.println("Wrong Login Detail");
			System.out.println("Please Enter Again");
			name = Util.sc.nextLine();
		}
		
		System.out.println("Successfully Logged In.");
		
		Connections connections = new Connections();
		connections.initConnections();
		Organisations organisations = new Organisations();
		organisations.initOrganisations();
		Posts posts = new Posts();
		posts.initPosts();
		
		
		Util.setSessionId(name);
		while (true) {
			displayAndPerformAction(menu);
		}
	}
}
