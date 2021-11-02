package perscholas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.form.SignUpForm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable Integer id) {
		User user = userDao.findById(id);
		return user;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getByEmail(@RequestParam String email) {
		User user = userDao.findByEmail(email);
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		User user = userDao.findById(id);
		userDao.delete(user);
		return "{\"status\",\"ok\"}";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody @Valid SignUpForm form, BindingResult bindingResult) {

		System.out.println(form);

		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				System.out.println(error.getField() + " = " + error.getDefaultMessage());
				errors.add(error.getDefaultMessage());
			}

			String json = new Gson().toJson(errors);
			return json;
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

		// go to next next page
		String json = new Gson().toJson(user);
		return json;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody @Valid SignUpForm form, BindingResult bindingResult) {
		// do your error checking​
		User user = userDao.findById(form.getId());
		user.setEmail(form.getEmail());
		String encoded = encoder.encode(form.getPassword());
		user.setPassword(encoded);
		user.setGender(form.getGender());
		user.setAge(form.getAge());
		userDao.save(user);

		String json = new Gson().toJson(user);
		return json;

	}



//		// yaml
//		requestBody:
//	        content:
//	          application/x-www-form-urlencoded:
//	            schema:
//	              type: object
//	              properties:
//	                color:
//	                  type: array
//	                  items:
//	                    type: string
//	            encoding:
//	              color:            # color=red,green,blue
//	                style: form
//	                explode: false
//	     // application properties
//	     requestBody.content.application/x-www-form-urlencoded.schema.type=object
//	     requestBody.content.application/x-www-form-urlencoded.schema.type.properties.color.type=array
}
