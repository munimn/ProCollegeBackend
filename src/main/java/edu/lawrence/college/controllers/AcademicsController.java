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
import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.dtos.AcademicsDTO;
import edu.lawrence.college.dtos.AcademicsSummary;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;

@RestController
@RequestMapping("/academics")
@CrossOrigin(origins = "*")
public class AcademicsController {

	private AcademicsService ps;
    
	public AcademicsController(AcademicsService ps) {
        this.ps = ps;
    }
	@PostMapping
    public ResponseEntity<AcademicsDTO> save(Authentication authentication,@RequestBody AcademicsDTO profile) {
    	CollegeUserDetails details = (CollegeUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
    	try {
    		ps.save(id,profile);
    	} catch(WrongUserException ex) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(profile);
    	} catch(CollegeNotListedException ex) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body(profile);
    	}
    	return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }
	@GetMapping("/college/{collegeid}")
	public ResponseEntity<List<Academics>> findAll(@PathVariable("collegeid") UUID collegeid) {
		List<Academics> result = ps.findByCollegeid(collegeid);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{collegeid}")
	public ResponseEntity<AcademicsSummary> findAllSummary(@PathVariable("collegeid") UUID collegeid) {
		AcademicsSummary result = ps.summary(collegeid);
		return ResponseEntity.ok().body(result);
	}
}
