package edu.lawrence.college.dtos;

import edu.lawrence.college.entities.Profile;

public class ProfileDTO {
	private String user;
	private String fullname;
	private String email;
	private String phone;
	private String college;
	private String bio;
	
	public ProfileDTO() {}

	public ProfileDTO(Profile core) {
		user = core.getUser().getUserid().toString();
		fullname = core.getFullname();
		email = core.getEmail();
		phone = core.getPhone();
		college =core.getCollege().getCollegeid().toString();
		bio = core.getBio();
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}