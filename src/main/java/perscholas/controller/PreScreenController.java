package perscholas.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.PreScreenDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.PreScreen;
import perscholas.database.entity.User;
import perscholas.form.PreScreenForm;

@Controller
public class PreScreenController {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PreScreenDAO preScreenDao;
	
	
	
	@GetMapping("/prescreen")
	public ModelAndView showPreScreenPage(Principal principal) {
		ModelAndView modelandview = new ModelAndView("signup/prescreen");
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		modelandview.addObject("user", user);
	    return modelandview; 
	}
	
	@RequestMapping(value = "/prescreen", method = RequestMethod.POST)
	public ModelAndView preScreenSubmit(@Valid PreScreenForm form, BindingResult bindingResult, Principal principal) throws Exception {
		ModelAndView result = new ModelAndView("signup/prescreen");

		// form validation
		result.addObject("form", form);

		System.out.println(form); //jj

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
		
		  PreScreen prescreen = new PreScreen();
		  String email = principal.getName();
		  User user = userDao.findByEmail(email);
		  preScreenDao.deleteAnswers(user.getId());

		  prescreen.setHeight(form.getHeight());
		  
		  prescreen.setWeight(form.getWeight());
		  prescreen.setGoalWeight(form.getGoalWeight());
		  Double bmi = form.getWeight() / ((form.getHeight() * 0.01) * (form.getHeight() * 0.01));
		  prescreen.setBmi(Math.round(bmi*10.0)/10.0);
		 
		  prescreen.setUser(user);
		  Double femaleRmr =  ((10 * form.getWeight()) + (6.25 * form.getHeight()) - (5 * user.getAge()) - 161);
		  Double maleRmr = ((10 * form.getWeight()) + (6.25 * form.getHeight()) - (5 * user.getAge()) + 5);
		  if(user.getGender().equals("Female")) {
			  prescreen.setRmr(Math.round(femaleRmr*10.0)/10.0);
		  } else if (user.getGender().equals("Male")) {
			  prescreen.setRmr(Math.round(maleRmr*10.0)/10.0);
		  }
		 
		
		//Create a new prescreen object in the database
		preScreenDao.save(prescreen);

		// goto the next page

		ModelAndView result2 = new ModelAndView("redirect:/profile");
		return result2;
	}
}
