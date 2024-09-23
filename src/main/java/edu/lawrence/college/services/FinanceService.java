package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.AcademicsDTO;
import edu.lawrence.college.dtos.AcademicsSummary;
import edu.lawrence.college.dtos.AnswerDTO;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.FinanceSummary;
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
import edu.lawrence.college.repositories.FinanceRepository;
import edu.lawrence.college.repositories.ProfileRepository;
import edu.lawrence.college.repositories.QuestionRepository;
import edu.lawrence.college.repositories.StudentlifeRepository;
import edu.lawrence.college.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FinanceService {
	
	@Autowired
	FinanceRepository financeRepository;
	@Autowired
	AcademicsRepository academicsRepository;
	@Autowired
	UserRepository userRepository;
	
	public String save(UUID userid,FinancesDTO finances)throws WrongUserException,CollegeNotListedException {
		Optional<User> maybeUser = userRepository.findById(userid);
		if(!maybeUser.isPresent())
			throw new WrongUserException();
		
		User user = maybeUser.get();
		College college = user.getProfile().getCollege();
		if(college== null)
			throw new CollegeNotListedException();
		
		Finances newAcademics = new Finances(finances);
		newAcademics.setUser(user);
		newAcademics.setCollege(college);
		financeRepository.save(newAcademics);
		return newAcademics.getFinanceid().toString();
	}
	
	
	public List<Finances> findByCollegeid(UUID collegeid) {
		return financeRepository.findAllByCollegeid(collegeid);
	}
	public Optional<Finances> findByUserid(UUID collegeid) {
		return financeRepository.findByUserid(collegeid);
	}
	public FinanceSummary summary(UUID restaurantid) {
		FinanceSummary result = new FinanceSummary();
		result.setAvgFees(financeRepository.avgFees(restaurantid));
		result.setAvgFinancialaid(financeRepository.avgFinancialaid(restaurantid));
		result.setAvgGrant(financeRepository.avgGrant(restaurantid));
		result.setAvgRoomandboards(financeRepository.avgRoomandboards(restaurantid));
		result.setAvgScholarship(financeRepository.avgScholarship(restaurantid));
		result.setAvgTution(financeRepository.avgTution(restaurantid));
		return result;
	}
	
	
}
