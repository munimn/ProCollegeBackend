package edu.lawrence.college.dtos;


import edu.lawrence.college.entities.User;

public class UserDTO {
	private String name;
	private String password;
	private String token;
	
	public UserDTO() { token = ""; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
