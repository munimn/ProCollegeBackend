package edu.lawrence.college.dtos;

import java.util.UUID;

import edu.lawrence.college.entities.Studentlife;
import edu.lawrence.college.entities.User;

public class StudentlifeDTO {
	private String studentlifeid;
	private int campusenv;
	private int clubs;
	private int greeklife;
	private int studentorgs;
	private int adminhelp;
	private int cafequality;
	private String user;
	private String collegeid;
	public StudentlifeDTO() {
		
	}
	public StudentlifeDTO(Studentlife core) {
		studentlifeid = core.getStudentlifeid().toString();
		campusenv = core.getCampusenv();
		clubs = core.getClubs();
		greeklife = core.getGreeklife();
		studentorgs = core.getStudentorgs();
		adminhelp = core.getAdminhelp();
		cafequality = core.getCafequality();
		user = core.getUser().getUserid().toString();
		collegeid = core.getCollege().getCollegeid().toString();
	}
	 public String getCollegeid() {
		 return collegeid;
	 }
	 public void setCollegeid(String collegeid) {
		 this.collegeid = collegeid;
	 }
	public String getStudentlifeid() {
		return studentlifeid;
		
	}
	public void setStudentlifeid(String studentlifeid) {
		this.studentlifeid = studentlifeid;
	}
	 public String getUser() {
		 return user;
	 }
	 public void setUser(String user) {
		 this.user = user;
	 }
	 
	 public int getCampusenv() {
		 return campusenv;
		 
	 }
	 public void setCampusenv(int campusenv) {
		 this.campusenv = campusenv;
	 }
	 public int getClubs() {
		 return clubs;
		 
	 }
	 public void setClubs(int clubs) {
		 this.clubs = clubs;
	 }
	 public int getGreeklife() {
		 return greeklife;
		 
	 }
	 public void setGreeklife(int greeklife) {
		 this.greeklife = greeklife;
	 }
	 public int getStudentorgs() {
		 return studentorgs;
		 
	 }
	 public void setStudentorgs(int studentorgs) {
		 this.studentorgs = studentorgs;
	 }
	 public int getAdminhelp() {
		 return adminhelp;
		 
	 }
	 public void setAdminhelp(int adminhelp) {
		 this.adminhelp = adminhelp;
	 }
	 public int getCafequality() {
		 return cafequality;
	 }
	 public void setCafequality(int cafequality ) {
		 this.cafequality = cafequality;
	 } 

	

}
