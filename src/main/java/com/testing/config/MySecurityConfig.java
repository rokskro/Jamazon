package com.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		//.csrf().disable()
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		//.and()
		.authorizeRequests()
		.antMatchers("/api/**").hasRole("NORMAL")
		.antMatchers("/security/**").hasRole("ADMIN")
		   .anyRequest()
		   .authenticated()
		   .and()
		   .httpBasic();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Preeti")
		.password(this.passwordEncoder().encode("welcome"))
		.roles("NORMAL");

		auth.inMemoryAuthentication()
		.withUser("Conor")
		.password(this.passwordEncoder().encode("Amazon"))
		.roles("ADMIN");
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
	
	//List getting password + email
	//grab users, encode password when adding to list (two lists one for user one for admin)
	//Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
	//SecurityContextHolder.getContext().setAuthentication(authentication);
}
  