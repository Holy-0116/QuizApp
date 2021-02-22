package model;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String mail;
	private String pass;

	public User() {};
	
	public User(String name, String mail, String pass) {
		this.name = name;
		this.pass = pass;
		this.mail = mail;
	}
	
	public User(int id, String name, String pass, String mail) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.mail = mail;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getMail() {
		return this.mail;
	}

	public String getPass() {
		return this.pass;
	}


}
