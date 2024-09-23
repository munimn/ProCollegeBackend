package edu.lawrence.college.entities;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.college.dtos.FinancesDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="finances")
public class Finances {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID financeid;
	@OneToOne
	@JoinColumn(name="userid")
	private User user;
	private int financialaid;
	private int grants;
	private int scholarship;
	private int tution;
	private int roomandboards;
	private int fees;
    @ManyToOne
    @JoinColumn(name="collegeid")
    private College college;
	
	public Finances() {}
	public Finances(FinancesDTO core ) {
		financialaid = core.getFinancialaid();
		grants = core.getGrant();
		scholarship = core.getScholarship();
		tution = core.getTution();
		roomandboards = core.getRoomandboards();
		fees = core.getFees();
	}
	
	
	
	
	public UUID getFinanceid() {
		return financeid;
		
	}
	public void setFinanceid(UUID financeid) {
		this.financeid = financeid;
	}
	 public User getUser() {
		 return user;
	 }
	 public void setUser(User user) {
		 this.user = user;
	 }
	 public College getCollege() {
		 return college;
	 }
	 public void setCollege(College college) {
		 this.college = college;
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
