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
		ModelAndView result = new ModelAndView("signup/hhqForm");
		String[] i = request.getParameterValues("id");
		
		result.addObject("request", request);
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		hhqAnswersDao.deleteAnswers(user.getId());
		for ( String key : request.getParameterMap().keySet()) {
			String value = request.getParameter(key);
			System.out.println(key + " " + " " + value);
			 HhqAnswers hhqAnswers = new HhqAnswers();
			 hhqAnswers.setUser(user);
			  hhqAnswers.setHhq(hhqDao.findById(Integer.parseInt(key))); 
			  hhqAnswers.setCheckUncheck(1);
			  hhqAnswersDao.save(hhqAnswers);
		}

		
		List<HhqAnswers> hhqAnswers = hhqAnswersDao.getUserAnswers(user.getId());
		for(HhqAnswers answer: hhqAnswers) {
			int qId = answer.getHhq().getId();
			if(qId == 35) {
				
				ModelAndView result2 = new ModelAndView("redirect:/profile");
				return result2; 
			}else {
				
				ModelAndView result3 = new ModelAndView("redirect:/stop");
				return result3;
			}
			
				
			}


		return result;

	}

}
