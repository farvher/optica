package com.optica;

import com.optica.controllers.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.optica.entity.User;
import com.optica.services.login.UserService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	protected static final String[] ANY_MATCHER = { "/resources/**", "/", "/about", "/contact", "/blog", "/team",
			"/registration", "/detail/**", "/search/**", "/h2-console/*" , "/h2-console/**"};

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.csrf();

		http.authorizeRequests()
		.antMatchers(ANY_MATCHER)
		.permitAll()
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(authenticationSuccessHandler())
		.permitAll()
		.and()
		.logout()
		.permitAll();
		http.headers().frameOptions().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private AuthenticationSuccessHandler authenticationSuccessHandler() {

		return (request, response, authentication) -> {
			String username = ((User)authentication.getPrincipal()).getUsername();
			User loggedUser = userService.findByUsername(username);
			((User)authentication.getPrincipal()).setId(loggedUser.getId());
			((User)authentication.getPrincipal()).setEmail(loggedUser.getEmail());
			response.sendRedirect(Routes.PEOPLE_HOME);
		};

	}
}
