package edu.lawrence.college.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.User;

public interface UserRepository extends JpaRepository<User,UUID>{
	@Query("select u from User u where u.name=:name")
	List<User> findByName(String name);
}