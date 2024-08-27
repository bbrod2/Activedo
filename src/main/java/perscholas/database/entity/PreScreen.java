package perscholas.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;



@Entity
@Table(name = "pre_screen")
public class PreScreen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "rmr")
	private Double rmr;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "goal_weight")
	private Integer goalWeight;
	@Column(name = "days")
	private Integer days;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	@Column(name = "height")
	private Double height;
	@Column(name = "bmi")
	private Double bmi;

	public Integer getId() {
		return id;
	}

	public Double getRmr() {
		return rmr;
	}

	public Double getWeight() {
		return weight;
	}

	public Integer getGoalWeight() {
		return goalWeight;
	}

	public Integer getDays() {
		return days;
	}

	public Double getHeight() {
		return height;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRmr(Double rmr) {
		this.rmr = rmr;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setGoalWeight(Integer goalWeight) {
		this.goalWeight = goalWeight;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getBmi() {
		return bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(days, goalWeight, height, id, rmr, getUser(), weight);
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
		PreScreen other = (PreScreen) obj;
		return Objects.equals(days, other.days) && Objects.equals(goalWeight, other.goalWeight)
				&& Objects.equals(height, other.height) && Objects.equals(id, other.id)
				&& Objects.equals(rmr, other.rmr) && Objects.equals(getUser(), other.user)
				&& Objects.equals(weight, other.weight);
	}

	@Override
	public String toString() {
		return "PreScreen [id=" + id + ", rmr=" + rmr + ", weight=" + weight + ", goalWeight=" + goalWeight + ", days="
				+ days + ", userId=" + user + ", height=" + height + "]";
	}

}
