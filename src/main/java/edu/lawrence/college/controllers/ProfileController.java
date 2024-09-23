package edu.lawrence.college.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.college.services.*;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.services.CollegeUserDetails;
import edu.lawrence.college.services.JwtService;
import edu.lawrence.college.services.ProfileService;
import edu.lawrence.college.services.UserService;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

	private ProfileService ps;
    
	public ProfileController(ProfileService ps) {
        this.ps = ps;
    }
    @PostMapping()
    public ResponseEntity<ProfileDTO> save(Authentication authentication,@RequestBody ProfileDTO profile) {
    	CollegeUserDetails details = (CollegeUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
    	try {
    		ps.save(id,profile);
    	} catch(WrongUserException ex) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(profile);
    	} catch(DuplicateException ex) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body(profile);
    	}
    	return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }
    @GetMapping
    public ResponseEntity<ProfileDTO> getProfile(Authentication authentication) {
    	CollegeUserDetails details = (CollegeUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
    	Profile result = ps.findByUser(id);
    	if(result == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	ProfileDTO response = new ProfileDTO(result);
    	return ResponseEntity.ok().body(response);
    }
	@GetMapping("/{collegeid}")
	public ResponseEntity<List<Profile>> findByCollegeid(@PathVariable("collegeid") UUID collegeid) {
		List<Profile> result = ps.findByCollege(collegeid);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{userid}")
	public ResponseEntity<Profile> findByUserid(@PathVariable("userid") UUID userid) {
		Profile result = ps.findByUser(userid);
		return ResponseEntity.ok().body(result);
	}
}
