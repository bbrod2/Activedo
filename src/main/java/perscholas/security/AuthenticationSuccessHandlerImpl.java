package perscholas.security;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;



@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		// Log the successful authentication
		System.out.println("Authentication successful for user: " + authentication.getName());

		// Log the old session ID
		String oldSessionId = request.getSession().getId();
		System.out.println("Old Session ID: " + oldSessionId);

		// Ensure that the authentication is set in the SecurityContextHolder
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Redirect to the desired page after successful authentication
		UrlPathHelper helper = new UrlPathHelper();
		String contextPath = helper.getContextPath(request);
		response.sendRedirect(contextPath + "/hhqForm");

		// Log the new session ID after redirection
		String newSessionId = request.getSession().getId();
		System.out.println("New Session ID: " + newSessionId);
	}
}
