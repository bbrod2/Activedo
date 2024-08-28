package perscholas.database.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "form_hhq")
public class Hhq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "question")
	private String question;
	@Column(name = "type")
	private String type;
	@OneToMany(mappedBy = "hhq", fetch = FetchType.LAZY)
   	private List<HhqAnswers> hhqAnswers  = new ArrayList<HhqAnswers>();
	public Integer getId() {
		return id;
	}
	public String getQuestion() {
		return question;
	}
	public String getType() {
		return type;
	}
	public List<HhqAnswers> getHhqAnswers() {
		return hhqAnswers;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setHhqAnswers(List<HhqAnswers> hhqAnswers) {
		this.hhqAnswers = hhqAnswers;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hhqAnswers, id, question, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Hhq other = (Hhq) obj;
		return Objects.equals(hhqAnswers, other.hhqAnswers) && Objects.equals(id, other.id)
				&& Objects.equals(question, other.question) && Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Hhq [id=" + id + ", question=" + question + ", type=" + type + ", hhqAnswers=" + hhqAnswers + "]";
	}
}
