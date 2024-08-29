package perscholas.controller;

import java.security.Principal;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.HhqAnswersDAO;
import perscholas.database.dao.HhqDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.Hhq;
import perscholas.database.entity.HhqAnswers;
import perscholas.database.entity.User;

@Controller
public class HhqController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private HhqAnswersDAO hhqAnswersDao;

	@Autowired
	private HhqDAO hhqDao;

	@RequestMapping(value = "/hhqForm", method = RequestMethod.GET)
	public ModelAndView hhqForm(Principal principal) {
		ModelAndView result = new ModelAndView("signup/hhqForm");
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		result.addObject("user", user);
		// List<Hhq> userQuestions = hhqDao.getUserAnsQuestions(user.getId());
		// result.addObject("userQuestions", userQuestions);

		return result;

	}

	@RequestMapping(value = "/hhqSubmit", method = RequestMethod.POST)
	public ModelAndView hhqInputSubmit(HttpServletRequest request, Principal principal) {
		// Initialize the default view to redirect to the HHQ form page
		ModelAndView result = new ModelAndView("signup/hhqForm");

		// Get the currently logged-in user's email and retrieve the user object
		String email = principal.getName();
		User user = userDao.findByEmail(email);

		// Delete the user's previous answers before saving new ones
		hhqAnswersDao.deleteAnswers(user.getId());

		// Loop through each key in the request parameter map
		for (String key : request.getParameterMap().keySet()) {
			if (key.equals("_csrf")) {
				continue; // Skip the CSRF token parameter
			}

			try {
				// Parse the question ID from the key and find the corresponding Hhq object
				int questionId = Integer.parseInt(key);
				Hhq question = hhqDao.findById(questionId);

				if (question != null) { // Ensure the question exists
					// Create a new HhqAnswers object and populate its fields
					HhqAnswers hhqAnswers = new HhqAnswers();
					hhqAnswers.setUser(user);
					hhqAnswers.setHhq(question);
					hhqAnswers.setCheckUncheck(1); // Assuming '1' means the checkbox is checked

					// Save the answer to the database
					hhqAnswersDao.save(hhqAnswers);
				}
			} catch (NumberFormatException e) {
				// Log and skip any keys that aren't valid integers
				System.err.println("Invalid question ID: " + key);
			}
		}

		// Retrieve all the user's answers from the database
		List<HhqAnswers> hhqAnswersList = hhqAnswersDao.getUserAnswers(user.getId());

		// Check the user's answers and redirect based on specific conditions
		boolean shouldRedirectToProfile = false;
		for (HhqAnswers answer : hhqAnswersList) {
			int qId = answer.getHhq().getId();

			if (qId == 35 && answer.getCheckUncheck() == 1) { // Ensure the specific checkbox is checked
				shouldRedirectToProfile = true;
				break; // Exit loop once the condition is met
			}
		}

		// Redirect to the appropriate page based on the user's answers
		if (shouldRedirectToProfile) {
			result = new ModelAndView("redirect:/profile");
		} else {
			result = new ModelAndView("redirect:/stop");
		}

		return result;
	}


}
