package edu.lawrence.college.repositories;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.Answer;
import edu.lawrence.college.entities.Question;

public interface AnswerRepository extends JpaRepository<Answer, UUID>{
	List<Answer> findAll();
	@Query("select r from Answer r where r.question.questionid=:questionid")
	List<Answer> findByQuestionid(UUID questionid);

}

