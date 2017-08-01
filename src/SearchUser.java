
public class SearchUser implements Action {

	@Override
	public void performAction() {
		String search="";
		Users users = new Users();
		
		System.out.println("Enter User Name");
		search = Util.sc.next();
		users.searchUser(search);
		

	}

}
