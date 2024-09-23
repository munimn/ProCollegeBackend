package edu.lawrence.college.dtos;

import java.util.UUID;

import edu.lawrence.college.entities.Finances;
import edu.lawrence.college.entities.User;

public class FinancesDTO {
	private String user;
    private String financeid;
	private int financialaid;
	private int grants;
	private int scholarship;
	private int tution;
	private int roomandboards;
	private int fees;
	private String collegeid;
	public FinancesDTO() {
		
	}
	public FinancesDTO(Finances core) {
		financeid = core.getFinanceid().toString();
		financialaid = core.getFinancialaid();
		grants = core.getGrant();
		scholarship = core.getScholarship();
		tution = core.getTution();
		roomandboards = core.getRoomandboards();
		fees = core.getFees();
		user = core.getUser().getUserid().toString();
		collegeid = core.getCollege().getCollegeid().toString();
		
		
	}
	public String getFinanceid() {
		return financeid;
		
	}
	public void setFinanceid(String financeid) {
		this.financeid = financeid;
	}
	 public String getUser() {
		 return user;
	 }
	 public void setUser(String user) {
		 this.user = user;
	 }
	 public String getCollegeid() {
		 return collegeid;
	 }
	 public void setCollegeid(String collegeid) {
		 this.collegeid = collegeid;
	 }
	 
	 public int getGrant() {
		 return grants;
		 
	 }
	 public void setGrant(int grant) {
		 this.grants = grant;
	 }
	 public int getFinancialaid() {
		 return financialaid;
		 
	 }
	 public void setFinancialaid(int financialaid) {
		 this.financialaid = financialaid;
	 }
	 public int getScholarship() {
		 return scholarship;
		 
	 }
	 public void setScholarship(int scholarship) {
		 this.scholarship = scholarship;
	 }
	 public int getTution() {
		 return tution;
		 
	 }
	 public void setTution(int tution) {
		 this.tution = tution;
	 }
	 public int getFees() {
		 return fees;
		 
	 }
	 public void setFees(int fees) {
		 this.fees = fees;
	 }
	 public int getRoomandboards() {
		 return roomandboards;
	 }
	 public void setRoomandboards(int roomandboards ) {
		 this.roomandboards = roomandboards;
	 }

}
