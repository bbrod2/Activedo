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

		synchronized (this) {
			// Invalidate the old session and create a new one
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				System.out.println("Thread ID: " + threadId + " - Old Session ID: " + oldSession.getId());
				oldSession.invalidate();
				System.out.println("Thread ID: " + threadId + " - Old Session invalidated.");
			}

			// Create a new session and log its ID
			HttpSession newSession = request.getSession(true);
			String newSessionId = newSession.getId();
			System.out.println("Thread ID: " + threadId + " - New Session ID created: " + newSessionId);

			// Update the SecurityContext with the correct session ID
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			SecurityContextHolder.setContext(securityContext);

			// Store the SecurityContext in the new session
			newSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

			// Ensure SecurityContext is synchronized
			SecurityContextHolder.setContext(SecurityContextHolder.getContext());

			// Log updates to the SecurityContext and session
			System.out.println("Thread ID: " + threadId + " - SecurityContext updated with new session ID: " + newSessionId);
			System.out.println("Thread ID: " + threadId + " - SecurityContext stored in session: " + newSessionId);

			// Redirect to the desired page after successful authentication
			UrlPathHelper helper = new UrlPathHelper();
			String contextPath = helper.getContextPath(request);
			response.sendRedirect(contextPath + "/hhqForm");

			// Log the final session ID after redirection
			System.out.println("Thread ID: " + threadId + " - Redirected with New Session ID: " + newSessionId);
		}
	}
}
