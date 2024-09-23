package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.AcademicsDTO;
import edu.lawrence.college.dtos.AcademicsSummary;
import edu.lawrence.college.dtos.AnswerDTO;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.FinancesDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.dtos.StudentlifeDTO;
import edu.lawrence.college.dtos.StudentlifeSummary;
import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Finances;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.entities.Studentlife;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.repositories.AcademicsRepository;
import edu.lawrence.college.repositories.AnswerRepository;
import edu.lawrence.college.repositories.CollegeRepository;
import edu.lawrence.college.repositories.ProfileRepository;
import edu.lawrence.college.repositories.QuestionRepository;
import edu.lawrence.college.repositories.StudentlifeRepository;
import edu.lawrence.college.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentlifeService {
	
	@Autowired
	StudentlifeRepository studentlifeRepository;
	
	@Autowired
	AcademicsRepository academicsRepository;
	@Autowired
	UserRepository userRepository;
	
	public String save(UUID userid,StudentlifeDTO finances)throws WrongUserException,CollegeNotListedException {
		Optional<User> maybeUser = userRepository.findById(userid);
		if(!maybeUser.isPresent())
			throw new WrongUserException();
		
		User user = maybeUser.get();
		College college = user.getProfile().getCollege();
		if(college== null)
			throw new CollegeNotListedException();
		
		Studentlife newAcademics = new Studentlife(finances);
		newAcademics.setUser(user);
		newAcademics.setCollege(college);
		studentlifeRepository.save(newAcademics);
		return newAcademics.getStudentlifeid().toString();
	}
	
	public List<Studentlife> findByCollegeid(UUID collegeid) {
		return studentlifeRepository.findAllByCollegeid(collegeid);
	}
	public Optional<Studentlife> findByUserid(UUID collegeid) {
		return studentlifeRepository.findByUserid(collegeid);
	}
	public StudentlifeSummary summary(UUID restaurantid) {
		StudentlifeSummary result = new StudentlifeSummary();
		result.setAvgAdminhelp(studentlifeRepository.avgAdminhelp(restaurantid));
		result.setAvgCafequality(studentlifeRepository.avgCafequality(restaurantid));
		result.setAvgCampusenv(studentlifeRepository.avgCampusenv(restaurantid));
		result.setAvgClubs(studentlifeRepository.avgClubs(restaurantid));
		result.setAvgGreeklife(studentlifeRepository.avgGreeklife(restaurantid));
		result.setAvgStudentorgs(studentlifeRepository.avgStudentorgs(restaurantid));
		return result;
	}
	
	
}