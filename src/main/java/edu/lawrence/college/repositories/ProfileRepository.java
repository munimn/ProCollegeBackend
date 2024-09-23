package edu.lawrence.college.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.Profile;
import edu.lawrence.college.entities.User;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	@Query("select p from Profile p where p.fullname=:fullname")
	List<Profile> findByName(String fullname);
	@Query("select p from Profile p where p.college.collegeid=:collegeid")
	List<Profile> findByCollege(UUID collegeid);
	@Query("select p from Profile p where p.user.userid=:userid")
	Optional<Profile> findByUser(UUID userid);
	
}
