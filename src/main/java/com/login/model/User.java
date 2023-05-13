package com.login.model;

public class User {
	
	private int UID;
	private String name;
	private String email;
	private String NIC;
	private String password;
	private String telephone;
	private boolean admin;
	
	public User(int uID, String name, String email, String nIC, String password, String telephone, boolean admin) {
		super();
		this.UID = uID;
		this.name = name;
		this.email = email;
		this.NIC = nIC;
		this.password = password;
		this.telephone = telephone;
		this.admin = admin;
	}

	public int getUID() {
		return UID;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getNIC() {
		return NIC;
	}

	public String getPassword() {
		return password;
	}

	public String getTelephone() {
		return telephone;
	}
	
	public boolean getAdmin() {
		return admin;
	}

}
