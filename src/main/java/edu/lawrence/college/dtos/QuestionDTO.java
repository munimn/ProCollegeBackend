package edu.lawrence.college.dtos;

import java.util.ArrayList;
import java.util.List;


import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.Question;

public class QuestionDTO {
	private String questionid;
	private String name;
	private String question;
	private List<String> answers;
	public QuestionDTO() {};
	public QuestionDTO(Question core) {
		questionid = core.getQuestionid().toString();
		name = core.getName();
		question = core.getQuestion();
		answers = new ArrayList<String>();
		List<Answer> tagList = core.getAnswers();
		for(Answer t : tagList) {
			answers.add(t.getAnswers());
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
	        return question;
	    }

	public void setQuestion(String question) {
	        this.question = question;
	    }
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	public List<String> getAnswer() {
		return answers;
	}
	
	

}
