package perscholas.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

import java.io.IOException;
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		long threadId = Thread.currentThread().getId();
		System.out.println("Authentication successful for user: " + authentication.getName() + " on Thread ID: " + threadId);

		// No need to invalidate and create new session manually; Spring Security will handle this

		// Redirect to the desired page after successful authentication
		response.sendRedirect(request.getContextPath() + "/hhqForm");

		System.out.println("Thread ID: " + threadId + " - Redirected to /hhqForm");
	}
}
