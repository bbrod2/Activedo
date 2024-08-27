package perscholas.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignUpForm {

	private Integer Id; 
	
	@NotEmpty(message = "Email can not be empty.")
	// @Email(message = "@Email is invalid")
	@Pattern(regexp = "^.*@.*$", message = "Email @Pattrn format invalid")
	private String email;

	@NotEmpty(message = "Password can not be empty.")
	@Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters")
	@Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least one digit 0 through 9")
	@Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter")
	@Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase letter")
	@Pattern(regexp = "(?=.*[!@#\\$%\\^&\\*]).+", message = "Password must contain at least one special character ! @ # $ % ^ & *")
	private String password;

	@NotEmpty(message = "Full name needed what ever you want to put.")
	private String full_name;

	@NotEmpty(message = "Input \"Male\" or \"Female\"")
	private String gender;

	private int age;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFull_name() {
		return full_name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SignUpForm [email=" + email + ", password=" + password + ", full_name=" + full_name + ", gender="
				+ gender + ", age=" + age + "]";
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

}
