package edu.lawrence.college.repositories;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID>{
	List<Question> findAll();
	@Query("select r from Question r where r.questionid=:questionid")
	List<Question> findByQuestionid(UUID questionid);

}
