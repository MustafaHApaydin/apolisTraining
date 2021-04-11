package myserlvets;

public class Users {
	private String user_name;
	private String pass;
	private String email;
	private String phone;
	private String user_address;
	
	
	public Users(String user_name, String pass, String email, String phone, String user_address) {
		super();
		this.user_name = user_name;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
		this.user_address = user_address;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.user_name+" : "+email+" : "+phone+" : "+user_address;
	}
	

}
