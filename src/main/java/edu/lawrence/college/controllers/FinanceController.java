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

import edu.lawrence.college.dtos.AcademicsDTO;
import edu.lawrence.college.dtos.AcademicsSummary;
import edu.lawrence.college.dtos.FinanceSummary;
import edu.lawrence.college.dtos.FinancesDTO;
import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.Finances;
import edu.lawrence.college.services.AcademicsService;
import edu.lawrence.college.services.CollegeNotListedException;
import edu.lawrence.college.services.CollegeUserDetails;
import edu.lawrence.college.services.FinanceService;
import edu.lawrence.college.services.WrongUserException;

@RestController
@RequestMapping("/finances")
@CrossOrigin(origins = "*")
public class FinanceController {
private FinanceService ps;
    
	public FinanceController(FinanceService ps) {
        this.ps = ps;
    }
	@PostMapping
    public ResponseEntity<FinancesDTO> save(Authentication authentication,@RequestBody FinancesDTO profile) {
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
	public ResponseEntity<List<Finances>> findAll(@PathVariable("collegeid") UUID collegeid) {
		List<Finances> result = ps.findByCollegeid(collegeid);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{collegeid}")
	public ResponseEntity<FinanceSummary> findAllSummary(@PathVariable("collegeid") UUID collegeid) {
		FinanceSummary result = ps.summary(collegeid);
		return ResponseEntity.ok().body(result);
	}

}
