package edu.lawrence.college.dtos;

import java.util.UUID;

import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.User;

public class AcademicsDTO {
	private String academicsid;
	private int ratio;
	private int classselection;
	private int workload;
	private int opportunities;
	private int advising;
	private int lectures;
	private String user;
	private String collegeid;
	public AcademicsDTO() {
		
	}
	public AcademicsDTO(Academics core) {
		academicsid = core.getAcademicsid().toString();
		ratio = core.getRatio();
		classselection = core.getClassselection();
		workload = core.getWorkload();
		opportunities = core.getOpportunities();
		advising = core.getAdvising();
		lectures = core.getLectures();
		user = core.getUser().getUserid().toString();
		collegeid = core.getCollege().getCollegeid().toString();
	}
	 public String getCollegeid() {
		 return collegeid;
	 }
	 public void setCollegeid(String collegeid) {
		 this.collegeid = collegeid;
	 }
	public String getAcademicsid() {
		return academicsid;
		
	}
	public void setAcademicsid(String academicsid) {
		this.academicsid = academicsid;
	}
	 public String getUser() {
		 return user;
	 }
	 public void setUser(String user) {
		 this.user = user;
	 }
	 
	 public int getRatio() {
		 return ratio;
		 
	 }
	 public void setRatio(int ratio) {
		 this.ratio = ratio;
	 }
	 public int getClassselection() {
		 return classselection;
		 
	 }
	 public void setClassselection(int classselection) {
		 this.classselection = classselection;
	 }
	 public int getWorkload() {
		 return workload;
		 
	 }
	 public void setWorkload(int workload) {
		 this.workload = workload;
	 }
	 public int getOpportunities() {
		 return opportunities;
		 
	 }
	 public void setOpportunities(int opportunities) {
		 this.opportunities = opportunities;
	 }
	 public int getAdvising() {
		 return advising;
		 
	 }
	 public void setAdvising(int advising) {
		 this.advising = advising;
	 }
	 public int getLectures() {
		 return lectures;
	 }
	 public void setLectures(int lectures ) {
		 this.lectures = lectures;
	 } 

}
