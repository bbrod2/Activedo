package perscholas.config;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionTrackingMode;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import perscholas.security.AuthenticationFailureHandlerImpl;
import perscholas.security.AuthenticationSuccessHandlerImpl;
import perscholas.security.SessionLoggingFilter;
import perscholas.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collections;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	AuthenticationSuccessHandlerImpl successHandler;

	@Autowired
	AuthenticationFailureHandlerImpl failureHandler;

	@Autowired
	UserDetailsServiceImpl userDetailsService;



	// Other beans and methods...

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.addFilterBefore(new SessionLoggingFilter(), UsernamePasswordAuthenticationFilter.class) // Add session logging filter
				.csrf(AbstractHttpConfigurer::disable)  // Disable CSRF protection if needed
				.authorizeHttpRequests(authorizeRequests ->
						authorizeRequests
								.requestMatchers("/index", "/index/*", "/login", "/login/**", "/error", "/css/**", "/js/**", "/signup", "/submitsignup", "/").permitAll()
								.requestMatchers("/WEB-INF/jsp/**").permitAll()
								.requestMatchers("/pub/**", "/images/**").permitAll()
								.anyRequest().authenticated()  // Require authentication for all other requests
				)
				.formLogin(formLogin -> formLogin
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.successHandler(successHandler)
						.failureHandler(failureHandler)
				)
				.logout(logout ->
						logout
								.logoutUrl("/logout")
								.logoutSuccessUrl("/login?logout")  // Redirect to /login after logout
								.permitAll()
				)
				.exceptionHandling(exceptionHandling ->
						exceptionHandling
								.accessDeniedPage("/error")  // Custom access denied page
				);

		return http.build();
	}




	@Bean(name = "passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}


	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new AuthenticationSuccessHandlerImpl();  // Your custom success handler
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new AuthenticationFailureHandlerImpl();  // Your custom failure handler
	}

	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean() {
		ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new HttpServlet() {
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				req.getSession().setMaxInactiveInterval(1800); // Set session timeout to 30 minutes (1800 seconds)
				resp.getWriter().write("Session timeout configured.");
			}
		}, "/configSessionTimeout");
		return bean;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.getSessionCookieConfig().setHttpOnly(true);
			servletContext.getSessionCookieConfig().setSecure(true); // Ensure it's secure
			servletContext.getSessionCookieConfig().setName("JSESSIONID");
			servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
		};
	}

	@Bean
	public FilterRegistrationBean<SessionLoggingFilter> loggingFilter(){
		FilterRegistrationBean<SessionLoggingFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new SessionLoggingFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

}
