package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.repositories.CollegeRepository;
import edu.lawrence.college.repositories.ProfileRepository;
import edu.lawrence.college.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CollegeService {
	
	@Autowired
	CollegeRepository collegeRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	public String save(UUID userid,CollegeDTO college)throws  WrongUserException, DuplicateException  {
		Optional<User> maybeUser = userRepository.findById(userid);
		if(!maybeUser.isPresent())
			throw new WrongUserException();
		
		User user = maybeUser.get();
		
		Optional<College> maybeCollege = collegeRepository.findByCollege(college.getName());
		if(maybeCollege.isPresent())
			throw new DuplicateException();
		
		College newCollege = new College(college);
		newCollege.setUser(user);
		collegeRepository.save(newCollege);
		return newCollege.getCollegeid().toString();
	}
	
	public Optional<College> findBycollegeid(UUID collegeid) {
		return collegeRepository.findByCollegeid(collegeid);
	}
	public Optional<College> findByuserid(UUID userid) {
		return collegeRepository.findByUser(userid);
	}
	
	public List<College> findAll() {
		return collegeRepository.findAll();
	}
	
	public Optional<College> findByCollege(String college) {
		return collegeRepository.findByCollege(college);
	}
	
}
