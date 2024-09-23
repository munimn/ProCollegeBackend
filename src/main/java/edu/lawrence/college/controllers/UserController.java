package edu.lawrence.college.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.college.dtos.UserDTO;
import edu.lawrence.college.entities.User;
import edu.lawrence.college.services.JwtService;
import edu.lawrence.college.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService us;
	private JwtService jwtService;
    
	public UserController(UserService us,JwtService jwtService) {
        this.us = us;
        this.jwtService = jwtService;
    }
	
    @PostMapping("/login")
    public ResponseEntity<UserDTO> checkLogin(@RequestBody UserDTO user) {
        User result = us.findByNameAndPassword(user.getName(), user.getPassword());
        if (result == null) {
        	user.setToken("Invalid user name or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        }
        String token = jwtService.makeJwt(result.getUserid().toString());
        user.setToken(token);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
        if (user.getName().isBlank() || user.getPassword().isBlank()) {
        	user.setToken("Empty user name or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }

        String key = us.save(user);
        if (key.equals("Duplicate")) {
        	user.setToken("User with this name already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
        } else if (key.equals("Error")) {
        	user.setToken("Can not generate key");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
        }
        String token = jwtService.makeJwt(key);
        user.setToken(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
