package perscholas.config;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import perscholas.security.AuthenticationFailureHandlerImpl;
import perscholas.security.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import perscholas.security.CustomAuthenticationFilter;
import perscholas.security.UserDetailsServiceImpl;

import java.io.IOException;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private AuthenticationSuccessHandlerImpl successHandler;

	@Autowired
	private AuthenticationFailureHandlerImpl failureHandler;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
		customAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		customAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());

		http

				.csrf(csrf -> csrf.disable())  // Disable CSRF protection if needed
				.authorizeHttpRequests(authorizeRequests ->
						authorizeRequests
								.requestMatchers("/index", "/index/*", "/login", "/login/**", "/error", "/css/**", "/js/**", "/signup", "/submitsignup", "/").permitAll()
								.requestMatchers("/WEB-INF/jsp/**").permitAll()
								.requestMatchers("/pub/**", "/images/**").permitAll()
								.requestMatchers("/hhqForm").authenticated()
								.anyRequest().authenticated()  // Require authentication for all other requests
				)
				.sessionManagement(sessionManagement ->
						sessionManagement
								.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)  // Create a session if it doesn't already exist
								.sessionFixation().migrateSession()// Protect against session fixation attacks
								.maximumSessions(1)
								.sessionRegistry(sessionRegistry())  // Limit to one session per user
								.expiredUrl("/login?expired=true")
								.maxSessionsPreventsLogin(true)
				)
				.formLogin(formLogin -> formLogin
						.loginPage("/login/login")
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


	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
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
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);  // Allows URLs with "%2F"
		firewall.setAllowSemicolon(true);  // Allows URLs with semicolons ";"
		firewall.setAllowBackSlash(true);  // Allows backslashes "\" in URLs
		firewall.setAllowUrlEncodedPercent(true);  // Allows URLs with "%25"
		firewall.setAllowUrlEncodedDoubleSlash(true);  // Allows double slashes "//" in URLs
		return firewall;
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
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
}


