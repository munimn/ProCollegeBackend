package edu.lawrence.college.entities;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.college.dtos.AcademicsDTO;
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
@Table(name="academics")
public class Academics {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID academicsid;
	private int ratio;
	private int classselection;
	private int workload;
	private int opportunities;
	private int advising;
	private int lectures;
	@OneToOne
	@JoinColumn(name="userid")
	private User user;
    @ManyToOne
    @JoinColumn(name="collegeid")
    private College college;
	public Academics() {}
	public Academics(AcademicsDTO core ) {
		ratio = core.getRatio();
		classselection = core.getClassselection();
		workload = core.getWorkload();
		opportunities = core.getOpportunities();
		advising = core.getAdvising();
		lectures = core.getLectures();
	}
	
	 public College getCollege() {
		 return college;
	 }
	 public void setCollege(College college) {
		 this.college = college;
	 }
	
	
	public UUID getAcademicsid() {
		return academicsid;
		
	}
	public void setAcademicsid(UUID academicsid) {
		this.academicsid = academicsid;
	}
	 public User getUser() {
		 return user;
	 }
	 public void setUser(User user) {
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
