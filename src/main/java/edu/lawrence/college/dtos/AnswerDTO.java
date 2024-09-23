package edu.lawrence.college.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.entities.User;

public class AnswerDTO {
	private String user;
	private String answerid;
	private String answer;
	private String questionid;
	public AnswerDTO() {};
	public AnswerDTO(Answer core) {
		user = core.getUser().getUserid().toString();
		answerid = core.getAnswerid().toString();
		answer = core.getAnswers();
		questionid = core.getQuestion().getQuestionid().toString();
	}
	public String getAnswerid() {
		return answerid;
	}

	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}


	public String getAnswers() {
		return answer;
		
	}
	public void setAnswers(String answer) {
		this.answer = answer;
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
