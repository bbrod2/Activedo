package perscholas.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;

@Controller
public class ProfileController {

	@Autowired
	private UserDAO userDao;

	@GetMapping("/profile")
	public ModelAndView showProfilepage(Principal principal) {
		ModelAndView modelandview = new ModelAndView("/login/profile");
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		modelandview.addObject("user", user);
		return modelandview;
	}

}
