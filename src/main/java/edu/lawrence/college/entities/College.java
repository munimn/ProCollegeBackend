package edu.lawrence.college.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.college.dtos.CollegeDTO;
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
@Table(name="college")
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID collegeid;
	private String name;
	private String address;
	private String year;
	private String emailadmission;
	@OneToOne
	@JoinColumn(name="userid")
	private User user;


	
	public College() {}
	public College(CollegeDTO core) {
		name = core.getName();
		address = core.getAddress();
		year = core.getYear();
		emailadmission = core.getEmailadmission();
		
	}

		

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public UUID getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(UUID collegeid) {
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
	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}