package perscholas.controller;


import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.form.SignUpForm;

@Controller
//@RequestMapping("/SignUp")
public class SignUpController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PasswordEncoder encoder;
	@PermitAll
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUpPage() {
        return new ModelAndView("signup/SignUp");
	}
	@PermitAll
	@RequestMapping(value = "/submitsignup", method = RequestMethod.POST)
	public ModelAndView signUpSubmit(@Valid SignUpForm form, BindingResult bindingResult) throws Exception {
		ModelAndView result = new ModelAndView("signup/SignUp");

		// form validation
		result.addObject("form", form);

		System.out.println(form);

		if (bindingResult.hasErrors()) {

			List<String> errors = new ArrayList<String>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				System.out.println(error.getField() + " = " + error.getDefaultMessage());
				errors.add(error.getDefaultMessage());
			}

			result.addObject("errorFields", bindingResult.getFieldErrors());
			result.addObject("errors", errors);

			return result;

		}

		// business logic
		User user = new User();

		user.setEmail(form.getEmail());
		String encoded = encoder.encode(form.getPassword());
		user.setPassword(encoded);
		user.setFullName(form.getFull_name());
		user.setGender(form.getGender());
		user.setAge(form.getAge());

		userDao.save(user);

		// goto the next page

		ModelAndView result2 = new ModelAndView("redirect:/login");
		return result2;
	}


	@PermitAll
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView result = new ModelAndView("index");
		return result;
	}


	@PermitAll
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView result = new ModelAndView("login/login");
		return result;
	}
	
	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	public ModelAndView stop() {
		ModelAndView result = new ModelAndView("login/stop");
		return result;
	}


	@PermitAll
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView result = new ModelAndView("login/login");
		return result;
	}
	
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/readUser/{id}", method = RequestMethod.POST) public
	 * ResponseEntity createUserSubmit(@PathVariable Integer id) throws Exception {
	 * User user = userDao.findById(id);
	 * 
	 * if ( user == null ) { return new ResponseEntity(HttpStatus.NOT_FOUND); }
	 * 
	 * return new ResponseEntity(HttpStatus.OK); }
	 */

}
