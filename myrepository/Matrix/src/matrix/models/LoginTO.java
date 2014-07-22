package matrix.models;

public class LoginTO {

	private String uname;
	private String password;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginTO(String uname, String password) {
		this.uname = uname;
		this.password = password;
	}
}