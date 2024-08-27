package perscholas.validation;

import java.util.logging.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;

public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

	public static final Logger LOG = (Logger) LoggerFactory.getLogger(EmailUniqueImpl.class);
	
	@Autowired 
	private UserDAO userDao; 
	
	public void initialize(EmailUnique constraintAnnotation) {
		
		
	}
	
	@Override 
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		User user = userDao.findByEmail(value);
		
		return (user == null);
	}
}
