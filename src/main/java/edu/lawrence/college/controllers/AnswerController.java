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
import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.dtos.AnswerDTO;
import edu.lawrence.college.dtos.CollegeDTO;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "*")
public class AnswerController {

	private AnswerService ps;
	private QuestionService qs;
    
	public AnswerController(AnswerService ps,QuestionService qs) {
        this.ps = ps;
        this.qs = qs;
    }
	
	 @PostMapping("/{qid}")
	    public ResponseEntity<AnswerDTO> save(Authentication authentication, @PathVariable("qid") UUID qid, @RequestBody AnswerDTO profile) {
	    	CollegeUserDetails details = (CollegeUserDetails) authentication.getPrincipal();
	    	UUID id = UUID.fromString(details.getUsername());
	    	try {
	    		ps.save(qid,id,profile);
	    	} catch(WrongUserException ex) {
	    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(profile);
	    	}
	    	return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	    }

	@GetMapping("/{userid}")
	public ResponseEntity<List<Answer>> findByQuestionid(@PathVariable("userid") UUID userid) {
		List<Answer> result = ps.findByQuestionid(userid);
		return ResponseEntity.ok().body(result);
	}
}
