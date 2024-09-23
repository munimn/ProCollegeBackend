package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.AcademicsDTO;
import edu.lawrence.college.dtos.AcademicsSummary;
import edu.lawrence.college.dtos.AnswerDTO;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.repositories.AcademicsRepository;
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
public class AcademicsService {
	
	@Autowired
	AcademicsRepository academicsRepository;
	@Autowired
	UserRepository userRepository;
	
	public String save(UUID userid,AcademicsDTO academics)throws WrongUserException,CollegeNotListedException {
		Optional<User> maybeUser = userRepository.findById(userid);
		if(!maybeUser.isPresent())
			throw new WrongUserException();
		
		User user = maybeUser.get();
		College college = user.getProfile().getCollege();
		if(college== null)
			throw new CollegeNotListedException();
		
		Academics newAcademics = new Academics(academics);
		newAcademics.setUser(user);
		newAcademics.setCollege(college);
		academicsRepository.save(newAcademics);
		return newAcademics.getAcademicsid().toString();
	}
	
	public List<Academics> findByCollegeid(UUID collegeid) {
		return academicsRepository.findAllByCollegeid(collegeid);
	}
	
	public Optional<Academics> findByUserid(UUID collegeid) {
		return academicsRepository.findByUserid(collegeid);
	}
	public AcademicsSummary summary(UUID restaurantid) {
		AcademicsSummary result = new AcademicsSummary();
		result.setAvgAdvising(academicsRepository.avgAdvising(restaurantid));
		result.setAvgClassselection(academicsRepository.avgClassselection(restaurantid));
		result.setAvgLectures(academicsRepository.avgLectures(restaurantid));
		result.setAvgRatio(academicsRepository.avgRatio(restaurantid));
		result.setAvgOpportunities(academicsRepository.avgOpportunities(restaurantid));
		result.setAvgWorkload(academicsRepository.avgWorkload(restaurantid));
		return result;
	}
	
	
}