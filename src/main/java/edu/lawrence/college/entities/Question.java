package edu.lawrence.college.entities;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import edu.lawrence.college.dtos.QuestionDTO;
import edu.lawrence.college.dtos.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
	private UUID questionid;
	private String name;
	private String question;
	@OneToMany(mappedBy="question")
	List<Answer> answers;	
	public Question() {}
	public Question(QuestionDTO core) {
		name = core.getName();
		question = core.getQuestion();
		
	}
	public UUID getQuestionid() {
		return questionid;
	}
	public void setQuestionid(UUID questionid) {
		this.questionid = questionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getQuestion() {
		return question;
		
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers(){
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
