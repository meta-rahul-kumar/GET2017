
public class User {
	private String userId;
	private String userName;
	private String userGender;
	private String userPhone;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	void setUser(String userId, String userName, String userGender, String userPhone) {
		this.userId = userId;
		this.userName = userName;
		this.userGender = userGender;
		this.userPhone = userPhone;
	}
	
	String getUserId() {
		return userId;
	}
	
	String getUserName() {
		return userName;
	}
	
	String getUserGender() {
		return userGender;
	}
	
	String getUserPhone() {
		return userPhone;
	}
}
