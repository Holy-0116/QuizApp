package model;

public class Login {
	private String mail;
	private String pass;
	
	public Login(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public String getPass() {
		return this.pass;
	}

}
