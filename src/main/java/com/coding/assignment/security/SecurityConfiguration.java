package com.coding.assignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        	.withUser("foo")
        	.password("foo")
        	.authorities("USER")
        	.and()
	    	.withUser("bar")
	    	.password("bar")
	    	.authorities("USER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable()
			.antMatcher("/api/**")
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().httpBasic()
			.authenticationEntryPoint(authEntryPoint);
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}