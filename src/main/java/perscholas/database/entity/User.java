package perscholas.database.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "age")
	private int age;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserRole> userRoles = new ArrayList<UserRole>();
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserFood> userFood = new ArrayList<UserFood>();
	@OneToOne(mappedBy = "user")
	private PreScreen prescreen;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<HhqAnswers> hhqAnswers = new ArrayList<HhqAnswers>();

	public List<UserFood> getUserFood() {
		return userFood;
	}

	public void setUserFood(List<UserFood> userFood) {
		this.userFood = userFood;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public PreScreen getPrescreen() {
		return prescreen;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setPrescreen(PreScreen prescreen) {
		this.prescreen = prescreen;
	}



	public List<HhqAnswers> getHhqAnswers() {
		return hhqAnswers;
	}

	public void setHhqAnswers(List<HhqAnswers> hhqAnswers) {
		this.hhqAnswers = hhqAnswers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, fullName, gender, id, password);
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
		User other = (User) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName + ", gender="
				+ gender + ", age=" + age + "]";
	}
}
