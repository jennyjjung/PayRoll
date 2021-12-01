package ca.sheridancollege.jungjuyo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler; // access denied handler we created.
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http.csrf().disable();		
		http.headers().frameOptions().disable();

		http
			.authorizeRequests()
				.antMatchers("/ownerPage").hasRole("OWNER")
				.antMatchers("/addEmployee").hasRole("OWNER")
				.antMatchers("/edit/**").hasRole("OWNER")
				.antMatchers("/employeePage").hasRole("EMPLOYEE")
				.antMatchers("/", "/images/**", "/css/**").permitAll() 
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers(HttpMethod.POST, "/addEmployee").permitAll() 
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login").permitAll()
			.and()
				.logout()
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login?logout")
					.permitAll()
			.and()
				.exceptionHandling()
					.accessDeniedHandler(accessDeniedHandler);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void conigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
