package perscholas.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.FoodLogDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.dao.UserFoodDAO;
import perscholas.database.entity.FoodLog;
import perscholas.database.entity.User;
import perscholas.database.entity.UserFood;
import perscholas.form.AddFoodItemForm;
import perscholas.form.FoodInputForm;

@Controller
public class FoodLogController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private FoodLogDAO foodLogDao;

	@Autowired
	private UserFoodDAO userFoodDao;

	@RequestMapping(value = "/foodlog", method = RequestMethod.GET)
	public ModelAndView showFoodLogpage(Principal principal, @RequestParam(required = false, defaultValue= "1") Integer day) {

		// Fix Queries to include breakfast lunch and dinner
		// put day in the model
		// Fix jsp page so add day to url upon click of day button ?day=1
		// Fix jsp page to show the day in the title from the model
		// Loop over and display breakfast lunch and dinner
		// Remove extra copy and paste code done

		ModelAndView modelandview = new ModelAndView("/login/foodlog");

		String email = principal.getName();
		User user = userDao.findByEmail(email);
		modelandview.addObject("user", user);		
		Integer currentDay = day;
		modelandview.addObject("day", currentDay);
		List<FoodLog> userfoodLog = foodLogDao.getUserFoodLog(user.getId(), "breakfast", currentDay);
		modelandview.addObject("breakfastlog", userfoodLog);
		List<FoodLog> userLunchLog = foodLogDao.getUserFoodLog(user.getId(), "lunch", currentDay);
		modelandview.addObject("lunchlog", userLunchLog);
		List<FoodLog> userDinnerLog = foodLogDao.getUserFoodLog(user.getId(), "dinner", currentDay);
		modelandview.addObject("dinnerlog", userDinnerLog);
		List<FoodLog> userSnackLog = foodLogDao.getUserFoodLog(user.getId(), "snack", currentDay);
		modelandview.addObject("snacklog", userSnackLog);

		return modelandview;

	}

	@RequestMapping(value = "/foodlog", method = RequestMethod.POST)
	public ModelAndView foodInputSubmit(@Valid FoodInputForm form, BindingResult bindingResult, Principal principal)
			throws Exception {
		ModelAndView result = new ModelAndView("login/foodlog");

		// form validation
		result.addObject("form", form);

		System.out.println(form); // jj

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

		FoodLog foodlog = new FoodLog();
		foodlog.setFoodName(form.getFoodName());
		foodlog.setQuantity(form.getQuantity());
		foodlog.setCalories(form.getCalories());
		foodLogDao.save(foodlog);
		return result;

	}

	@RequestMapping(value = "/breakFast", method = RequestMethod.POST)
	public ModelAndView foodAddItemSubmit(@Valid AddFoodItemForm bform, BindingResult bindingResult,
			Principal principal, @RequestParam(required = false) Integer day) throws Exception {
		ModelAndView result = new ModelAndView("login/foodlog");

		// form validation result.addObject("form", form);

		System.out.println(bform); // jj

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
		Integer currentDay = day;
		result.addObject("day", currentDay);
		UserFood userFood = new UserFood();
		String foodName = bform.getFoodName();
		FoodLog foodLog = foodLogDao.findByFoodName(foodName);
		
		userFood.setFoodLog(foodLog);
		userFood.setDay(bform.getDay());
		userFood.setMealType(bform.getMealType());
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		userFood.setUser(user);
		userFoodDao.save(userFood);
		
		List<FoodLog> userfoodLog = foodLogDao.getUserFoodLog(user.getId(), "breakfast", currentDay);
		result.addObject("breakfastlog", userfoodLog);
		List<FoodLog> userLunchLog = foodLogDao.getUserFoodLog(user.getId(), "lunch", currentDay);
		result.addObject("lunchlog", userLunchLog);
		List<FoodLog> userDinnerLog = foodLogDao.getUserFoodLog(user.getId(), "dinner", currentDay);
		result.addObject("dinnerlog", userDinnerLog);
		List<FoodLog> userSnackLog = foodLogDao.getUserFoodLog(user.getId(), "snacks", currentDay);
		result.addObject("snacklog", userSnackLog);

		return result;

	}

	@RequestMapping(value = "/lunch", method = RequestMethod.POST)
	public ModelAndView lunchAddItemSubmit(@Valid AddFoodItemForm bform, BindingResult bindingResult,
			Principal principal, @RequestParam(required = false) Integer day) throws Exception {
		ModelAndView result = new ModelAndView("login/foodlog");

		// form validation result.addObject("form", form);

		System.out.println(bform); // jj

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
		
		Integer currentDay = day;
		result.addObject("day", currentDay);
		UserFood userFood = new UserFood();
		String foodName = bform.getFoodName();
		FoodLog foodLog = foodLogDao.findByFoodName(foodName);
		userFood.setFoodLog(foodLog);
		userFood.setDay(bform.getDay());
		userFood.setMealType(bform.getMealType());
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		userFood.setUser(user);
		userFoodDao.save(userFood);
		List<FoodLog> userfoodLog = foodLogDao.getUserFoodLog(user.getId(), "breakfast", currentDay);
		result.addObject("breakfastlog", userfoodLog);
		List<FoodLog> userLunchLog = foodLogDao.getUserFoodLog(user.getId(), "lunch", currentDay);
		result.addObject("lunchlog", userLunchLog);
		List<FoodLog> userDinnerLog = foodLogDao.getUserFoodLog(user.getId(), "dinner", currentDay);
		result.addObject("dinnerlog", userDinnerLog);
		List<FoodLog> userSnackLog = foodLogDao.getUserFoodLog(user.getId(), "snacks", currentDay);
		result.addObject("snacklog", userSnackLog);

		return result;

	}

	@RequestMapping(value = "/dinner", method = RequestMethod.POST)
	public ModelAndView dinnerAddItemSubmit(@Valid AddFoodItemForm bform, BindingResult bindingResult,
			Principal principal, @RequestParam(required = false) Integer day) throws Exception {
		ModelAndView result = new ModelAndView("login/foodlog");

		// form validation result.addObject("form", form);

		System.out.println(bform); // jj

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
		Integer currentDay = day;
		result.addObject("day", currentDay);
		UserFood userFood = new UserFood();
		String foodName = bform.getFoodName();
		FoodLog foodLog = foodLogDao.findByFoodName(foodName);
		userFood.setFoodLog(foodLog);
		userFood.setDay(bform.getDay());
		userFood.setMealType(bform.getMealType());
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		userFood.setUser(user);
		userFoodDao.save(userFood);

		
		List<FoodLog> userfoodLog = foodLogDao.getUserFoodLog(user.getId(), "breakfast", currentDay);
		result.addObject("breakfastlog", userfoodLog);
		List<FoodLog> userLunchLog = foodLogDao.getUserFoodLog(user.getId(), "lunch", currentDay);
		result.addObject("lunchlog", userLunchLog);
		List<FoodLog> userDinnerLog = foodLogDao.getUserFoodLog(user.getId(), "dinner", currentDay);
		result.addObject("dinnerlog", userDinnerLog);
		List<FoodLog> userSnackLog = foodLogDao.getUserFoodLog(user.getId(), "snacks", currentDay);
		result.addObject("snacklog", userSnackLog);

		return result;

	}

	@RequestMapping(value = "/snack", method = RequestMethod.POST)
	public ModelAndView snackAddItemSubmit(@Valid AddFoodItemForm bform, BindingResult bindingResult,
			Principal principal, @RequestParam(required = false) Integer day) throws Exception {
		ModelAndView result = new ModelAndView("login/foodlog");

		// form validation result.addObject("form", form);

		System.out.println(bform); // jj

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
		Integer currentDay = day;
		result.addObject("day", currentDay);
		UserFood userFood = new UserFood();
		String foodName = bform.getFoodName();
		FoodLog foodLog = foodLogDao.findByFoodName(foodName);
		userFood.setFoodLog(foodLog);
		userFood.setDay(bform.getDay());
		userFood.setMealType(bform.getMealType());
		String email = principal.getName();
		User user = userDao.findByEmail(email);
		userFood.setUser(user);
		userFoodDao.save(userFood);

		
		List<FoodLog> userfoodLog = foodLogDao.getUserFoodLog(user.getId(), "breakfast", currentDay);
		result.addObject("breakfastlog", userfoodLog);
		List<FoodLog> userLunchLog = foodLogDao.getUserFoodLog(user.getId(), "lunch", currentDay);
		result.addObject("lunchlog", userLunchLog);
		List<FoodLog> userDinnerLog = foodLogDao.getUserFoodLog(user.getId(), "dinner", currentDay);
		result.addObject("dinnerlog", userDinnerLog);
		List<FoodLog> userSnackLog = foodLogDao.getUserFoodLog(user.getId(), "snacks", currentDay);
		result.addObject("snacklog", userSnackLog);

		return result;

	}

}
