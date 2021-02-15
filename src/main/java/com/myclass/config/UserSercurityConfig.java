package com.myclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.myclass.filter.AuthFilter;

@Configuration
@EnableWebSecurity
@Order(2)
public class UserSercurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		
		http.csrf().disable() // TẮT CHỨC NĂNG CHỐNG TẤN CÔNG GIẢ MẠO REQUEST
		.antMatcher("/api/**") 
		.authorizeRequests()
		.antMatchers("/api/user")
		.authenticated();
		
		http.addFilter(new AuthFilter(authenticationManager(), userDetailsService));
		
		// KHÔNG SỬ DỤNG SESSION
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}

