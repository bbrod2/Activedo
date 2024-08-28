package perscholas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import perscholas.security.AuthenticationFailureHandlerImpl;
import perscholas.security.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import perscholas.security.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private AuthenticationSuccessHandlerImpl successHandler;

	@Autowired
	private AuthenticationFailureHandlerImpl failureHandler;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> {
					csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
				})
				.authorizeHttpRequests(authorizeRequests -> authorizeRequests
						.requestMatchers("/signup", "/index", "/stop", "/pub/**", "/error/**", "/login/**").permitAll() // Allow access without authentication
						.anyRequest().authenticated() // All other requests require authentication
				)
				.formLogin(formLogin -> formLogin
						.loginPage("/login/login") // Custom login page
						.loginProcessingUrl("/login/j_security_check") // Custom login processing URL
						.successHandler(successHandler)
						.failureHandler(failureHandler)
				)
				.logout(logout -> logout
						.invalidateHttpSession(true)
						.logoutUrl("/login/logout")
						.logoutSuccessUrl("/index")
				)
				.rememberMe(rememberMe -> rememberMe
						.key("SR_KEY")
						.tokenValiditySeconds(60 * 60 * 24 * 2)
						.rememberMeParameter("remember-me")
				)
				.exceptionHandling(exceptionHandling -> exceptionHandling
						.accessDeniedPage("/error/404")
				);

		return http.build();
	}
*/





	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
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
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // Disable CSRF protection if needed
				.authorizeHttpRequests(authorizeRequests -> authorizeRequests
						.anyRequest().permitAll() // Allow all requests without authentication
				);

		return http.build();
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

}
