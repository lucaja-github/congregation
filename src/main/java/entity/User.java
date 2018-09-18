package entity;

public class User {
	private String phonenumber;
	private String username;
	private String password;
	public String getPhonenumber(){
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [phonenumber=" + phonenumber + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
