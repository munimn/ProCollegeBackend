package edu.lawrence.college.controllers;

import java.util.List;
import java.util.Optional;
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
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.services.CollegeUserDetails;
import edu.lawrence.college.services.JwtService;
import edu.lawrence.college.services.ProfileService;
import edu.lawrence.college.services.UserService;


@RestController
@RequestMapping("/college")
@CrossOrigin(origins = "*")
public class CollegeController {

	private CollegeService ps;
    
	public CollegeController(CollegeService ps) {
        this.ps = ps;
    }
    @PostMapping
    public ResponseEntity<CollegeDTO> save(Authentication authentication,@RequestBody CollegeDTO profile) {
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
	public ResponseEntity<List<College>> findAll() {
		List<College> result = ps.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/{collegeid}")
	public ResponseEntity<Optional<College>> findByCollegeid(@PathVariable("collegeid") UUID collegeid) {
		Optional<College> result = ps.findBycollegeid(collegeid);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/name/{college}")
	public ResponseEntity<Optional<College>> findByCollege(@PathVariable("collegeid") String college) {
		Optional<College> result = ps.findByCollege(college);
		return ResponseEntity.ok().body(result);
	}
	
}