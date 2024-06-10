package com.sunbeam.pojos;

import java.sql.Date;

public class User {
	private int id;
	private String first_Name;
	private String last_Name;
	private String email;
	private String password;
	private Date birth;
	private int status;
	private String role;
	
	public User() {
	}

	public User(int id, String first_Name, String last_Name, String email, String password, Date birth, int status,
			String role) {
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.status = status;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String firstName) {
		this.first_Name = firstName;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String lastName) {
		this.last_Name = lastName;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + first_Name + ", lastName=" + last_Name + ", email=" + email
				+ ", password=" + password + ", birth=" + birth + ", status=" + status + ", role=" + role + "]";
	}
}
