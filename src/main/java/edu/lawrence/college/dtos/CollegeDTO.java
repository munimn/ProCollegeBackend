package edu.lawrence.college.dtos;


import edu.lawrence.college.entities.College;


public class CollegeDTO {
	private String user;
	private String name;
	private String address;
	private String emailadmission;
	private String collegeid;
	private String year;
	
	public CollegeDTO() {
	}

	public CollegeDTO(College core) {
		user = core.getUser().getUserid().toString();
		name = core.getName();
		address = core.getAddress();
		year = core.getYear();
		emailadmission = core.getEmailadmission();
		collegeid = core.getCollegeid().toString();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getEmailadmission() {
		return emailadmission;
	}
	public void setEmailadmission(String emailadmission) {
		this.emailadmission = emailadmission;
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}

