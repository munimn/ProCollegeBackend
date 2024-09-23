package edu.lawrence.college.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String save(UserDTO user) {
		List<User> existing = userRepository.findByName(user.getName());
		if(existing.size() > 0)
			return "Duplicate";
		
		User newUser = new User();
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		userRepository.save(newUser);
		return newUser.getUserid().toString();
	}
	
	public User findByNameAndPassword(String name,String password) {
		List<User> existing = userRepository.findByName(name);
		if(existing.size() != 1)
			return null;
		User u = existing.get(0);
		if(password.equals(u.getPassword())) {
        	return u;
        }
        return null;	
	}
}

