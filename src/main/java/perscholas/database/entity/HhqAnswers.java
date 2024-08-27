package perscholas.database.entity;



import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "form_hhq_answers")
public class HhqAnswers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "check_uncheck")
	private Integer checkUncheck;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private Hhq hhq;
	public Integer getId() {
		return id;
	}
	public Integer getCheckUncheck() {
		return checkUncheck;
	}
	public User getUser() {
		return user;
	}
	public Hhq getHhq() {
		return hhq;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCheckUncheck(Integer checkUncheck) {
		this.checkUncheck = checkUncheck;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setHhq(Hhq hhq) {
		this.hhq = hhq;
	}
	@Override
	public int hashCode() {
		return Objects.hash(checkUncheck, hhq, id, user);
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
		HhqAnswers other = (HhqAnswers) obj;
		return Objects.equals(checkUncheck, other.checkUncheck) && Objects.equals(hhq, other.hhq)
				&& Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "HhqAnswers [id=" + id + ", checkUncheck=" + checkUncheck + ", user=" + user + ", hhq=" + hhq + "]";
	}
	
}
