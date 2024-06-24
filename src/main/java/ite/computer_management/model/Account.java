package ite.computer_management.model;

public class Account {
	private String fullName;
	private String userName;
	private String password;
	private String role;
	private String Gmail;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	
	public String getGmail() {
		return Gmail;
	}
	public void setGmail(String gmail) {
		Gmail = gmail;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Account(String fullName, String userName, String password, String role, String gmail) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.Gmail = gmail;
	}
	public Account(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public Account(String userName,String role, String gmail) {
		this.userName = userName;
		this.role = role;
		this.Gmail = gmail;
	}
	public Account() {};
	@Override
	public String toString() {
		return "Account [fullName=" + fullName + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
}
