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
import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.Question;
import edu.lawrence.college.dtos.ProfileDTO;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.services.CollegeUserDetails;
import edu.lawrence.college.services.JwtService;
import edu.lawrence.college.services.ProfileService;
import edu.lawrence.college.services.UserService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {

	private QuestionService ps;
    
	public QuestionController(QuestionService ps) {
        this.ps = ps;
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody QuestionDTO profile) {
    	String key;
		key = ps.save(profile);
        return ResponseEntity.ok().body(key);
    }
	@GetMapping
	public ResponseEntity<List<Question>> findAll() {
		List<Question> result = ps.findAll();
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{userid}")
	public ResponseEntity<List<Question>> findByUserid(@PathVariable("userid") UUID userid) {
		List<Question> result = ps.findByQuestionid(userid);
		return ResponseEntity.ok().body(result);
	}
}
