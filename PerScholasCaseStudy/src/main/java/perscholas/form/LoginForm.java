package perscholas.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {
	@NotEmpty(message = "Email can not be empty.")
	//@Email(message = "@Email is invalid")
	@Pattern(regexp = "^.*@.*$", message = "Email @Pattrn format invalid")
	private String email;
	
	@NotEmpty(message = "Password can not be empty.")
	@Size(min = 10, max = 25, message = "Password must be between 10 and 25 characters")
	@Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least one digit 0 through 9")
	@Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter")
	@Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase letter")
	@Pattern(regexp = "(?=.*[!@#\\$%\\^&\\*]).+", message = "Password must contain at least one special character ! @ # $ % ^ & *")
private String password;

	@NotEmpty(message = "Confirm Password is required.")
	private String confirmPassword;

	@NotEmpty(message = "Full name needed what ever you want to put.")
	private String full_name;

}
