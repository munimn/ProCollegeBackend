package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.AnswerDTO;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.repositories.AnswerRepository;
import edu.lawrence.college.repositories.CollegeRepository;
import edu.lawrence.college.repositories.ProfileRepository;
import edu.lawrence.college.repositories.QuestionRepository;
import edu.lawrence.college.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	QuestionRepository questionRepository;
	
	public String save(UUID qid, UUID userid,AnswerDTO answer)throws  WrongUserException {
		Optional<User> maybeUser = userRepository.findById(userid);
		if(!maybeUser.isPresent())
			throw new WrongUserException();
		List<Question> maybeQuestion = questionRepository.findByQuestionid(qid);
		Question question = maybeQuestion.getFirst();
		List<Answer> answers = question.getAnswers();
		User user = maybeUser.get();
		Answer newAnswer = new Answer(answer);
		newAnswer.setUser(user);
		answers.add(newAnswer);
		question.setAnswers(answers);
		newAnswer.setQuestion(question);
		answerRepository.save(newAnswer);
		return newAnswer.getAnswerid().toString();
	}
	
	public List<Answer> findByQuestionid(UUID collegeid) {
		return answerRepository.findByQuestionid(collegeid);
	}
	
	public List<Answer> findAll() {
		return answerRepository.findAll();
	}
	
}