package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.repositories.AnswerRepository;
import edu.lawrence.college.repositories.CollegeRepository;
import edu.lawrence.college.repositories.ProfileRepository;
import edu.lawrence.college.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	
	
	
	public String save(QuestionDTO question) {
		Question newQuestion = new Question(question);
		questionRepository.save(newQuestion);
		return newQuestion.getQuestionid().toString();
	}
	
	public List<Question> findByQuestionid(UUID collegeid) {
		return questionRepository.findByQuestionid(collegeid);
	}
	
	public List<Question> findAll() {
		return questionRepository.findAll();
	}
	
}