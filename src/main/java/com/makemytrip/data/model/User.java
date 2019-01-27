
package com.makemytrip.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	private String userName;
	private String email;
	private String password;

	
	public User() {
		super();
	}
	
	public User(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public User(long id, String userName, String email, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

