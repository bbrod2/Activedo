package perscholas.security;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class SessionLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SessionLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if necessary
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false); // false prevents creating a new session if one doesn't exist
        if (session != null) {
            logger.debug("Session ID: " + session.getId());
            session.getAttributeNames().asIterator().forEachRemaining(attr ->
                    logger.debug("Session Attribute - Name: " + attr + ", Value: " + session.getAttribute(attr))
            );
        } else {
            logger.debug("No active session found for this request.");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic if necessary
    }
}
