package com.testing.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

 
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	System.out.println("Checkpoint - PASSWORD");
        return new BCryptPasswordEncoder(10);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("Checkpoint - Configure Password/Email/etc.");
        http.authorizeRequests()
            .antMatchers("/users/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/users/**")
                .permitAll()
            .and()
            .logout().logoutSuccessUrl("/").permitAll();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }
    
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("u")
		.password(this.passwordEncoder().encode("p"))
		.roles("NORMAL");

		auth.inMemoryAuthentication()
		.withUser("Conor")
		.password(this.passwordEncoder().encode("Amazon"))
		.roles("ADMIN");
	}
     
     
}