package perscholas.database.entity;


import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "form_hhq_answers")
public class HhqAnswers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "check_uncheck", nullable = true)  // or false, depending on your requirements
	private Integer checkUncheck;

	@ManyToOne(optional = false)  // assuming a user is required
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@ManyToOne(optional = false)  // assuming a question is required
	@JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
	private Hhq hhq;

	// Getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCheckUncheck() {
		return checkUncheck;
	}

	public void setCheckUncheck(Integer checkUncheck) {
		this.checkUncheck = checkUncheck;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hhq getHhq() {
		return hhq;
	}

	public void setHhq(Hhq hhq) {
		this.hhq = hhq;
	}

	// Overriding hashCode, equals, and toString methods
	@Override
	public int hashCode() {
		return Objects.hash(checkUncheck, hhq, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		HhqAnswers other = (HhqAnswers) obj;
		return Objects.equals(checkUncheck, other.checkUncheck)
				&& Objects.equals(hhq, other.hhq)
				&& Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "HhqAnswers [id=" + id + ", checkUncheck=" + checkUncheck
				+ ", user=" + user + ", hhq=" + hhq + "]";
	}
}
