package models;

public class Login {
	
	private String userName = "";
	private String pwd = "";

	private boolean[] error = {false,false};
	
	public Login() {
		
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getPwd(){
		return this.pwd;
	}
	
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	
	public boolean[] getError() {
		return error;
	}
	
	
	
	
	
}