package edu.lawrence.college.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.college.dtos.AnswerDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
	private UUID answerid;
	private String answer;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	@ManyToOne
	private Question question;
	public Answer() {}
	public Answer(AnswerDTO core) {
		answer = core.getAnswers();
	}
	public UUID getAnswerid() {
		return answerid;
	}

	public void setAnswerid(UUID answerid) {
		this.answerid = answerid;
	}


	public String getAnswers() {
		return answer;
		
	}
	public void setAnswers(String answer) {
		this.answer = answer;
	}
	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public Question getQuestion(){
		return question;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
