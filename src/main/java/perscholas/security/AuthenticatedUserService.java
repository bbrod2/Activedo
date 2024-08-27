package perscholas.security;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import perscholas.database.dao.UserDAO;



public class AuthenticatedUserService {
	@Autowired
	UserDAO userDao;
	
	public String getCurrentUsername() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null && context.getAuthentication() != null) {
			final org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) context
					.getAuthentication().getPrincipal();
			return principal.getUsername();
		} else {
			return null;
		}
	}

	/*if (user == null) {
		user = userDao.findByEmail(getCurrentUsername());
		
	}*/

}

