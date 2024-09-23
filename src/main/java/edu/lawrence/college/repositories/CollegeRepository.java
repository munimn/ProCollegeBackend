package edu.lawrence.college.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.College;

public interface CollegeRepository extends JpaRepository<College, UUID>{
	List<College> findAll();
	@Query("select c from College c where c.collegeid=:collegeid")
	Optional<College> findByCollegeid(UUID collegeid);
	@Query("select c from College c where c.name=:name")
	Optional<College> findByCollege(String name);
	@Query("select c from College c where c.user.userid=:userid")
	Optional<College> findByUser(UUID userid);
	
	

}
