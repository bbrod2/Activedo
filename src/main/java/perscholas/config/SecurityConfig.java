package perscholas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
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

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> {
					csrf
							.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
					// or customize it further here
					// .ignoringRequestMatchers("/api/**"); // Disable CSRF for specific endpoints
				})
				.authorizeHttpRequests(authorizeRequests -> authorizeRequests
						.requestMatchers("/pub/**", "/error/**", "/login/**", "/search").permitAll()
						.requestMatchers("/admin/**").authenticated()
				)
				.formLogin(formLogin -> formLogin
						.loginPage("/login/login")
						.loginProcessingUrl("/login/j_security_check")
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
}
