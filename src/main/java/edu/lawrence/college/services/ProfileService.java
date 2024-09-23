package edu.lawrence.college.services;

import org.springframework.stereotype.Service;

import edu.lawrence.college.services.WrongUserException;
import edu.lawrence.college.services.DuplicateException;
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
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CollegeRepository collegeRepository;
	
	public String save(UUID userid,ProfileDTO profile)throws  WrongUserException, DuplicateException  {
		Optional<User> maybeUser = userRepository.findById(userid);
		if(!maybeUser.isPresent())
			throw new WrongUserException();
		
		User user = maybeUser.get();
		if(user.getProfile() != null)
			throw new DuplicateException();
		
		Optional<College> maybeCollege = collegeRepository.findByUser(userid);
		if(!maybeCollege.isPresent())
			throw new WrongUserException();
		College college = maybeCollege.get();
		Profile newProfile = new Profile(profile);
		newProfile.setCollege(college);
		newProfile.setUser(user);
		profileRepository.save(newProfile);
		user.setProfile(newProfile);
		profile.setUser(user.getUserid().toString());
		profile.setCollege(college.getCollegeid().toString());
		return newProfile.getProfileid().toString();
	}
	
	public Profile findByUser(UUID userid) {
		Optional<Profile> maybeProfile = profileRepository.findByUser(userid);
		Profile profile = maybeProfile.get();
		return profile;
		
	}
	
	public List<Profile> findByCollege(UUID userid) {
		return profileRepository.findByCollege(userid);
	}
	
}
