package edu.lawrence.college.entities;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.college.dtos.FinancesDTO;
import edu.lawrence.college.dtos.StudentlifeDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentlife")
public class Studentlife {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID studentlifeid;
	private int campusenv;
	private int clubs;
	private int greeklife;
	private int studentorgs;
	private int adminhelp;
	private int cafequality;
	@OneToOne
	@JoinColumn(name="userid")
	private User user;
    @ManyToOne
    @JoinColumn(name="collegeid")
    private College college;
	public Studentlife() {}
	public Studentlife(StudentlifeDTO core ) {
		campusenv = core.getCampusenv();
		clubs = core.getClubs();
		greeklife = core.getGreeklife();
		studentorgs = core.getStudentorgs();
		adminhelp = core.getAdminhelp();
		cafequality = core.getCafequality();
	}
	
	 public College getCollege() {
		 return college;
	 }
	 public void setCollege(College college) {
		 this.college = college;
	 }
	
	
	public UUID getStudentlifeid() {
		return studentlifeid;
		
	}
	public void setStudentlifeid(UUID studentlifeid) {
		this.studentlifeid = studentlifeid;
	}
	 public User getUser() {
		 return user;
	 }
	 public void setUser(User user) {
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
