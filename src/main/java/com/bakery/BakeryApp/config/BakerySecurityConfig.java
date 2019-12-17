package com.bakery.BakeryApp.config;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class BakerySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("barista").password("barista").roles("barista"))
			.withUser(users.username("admin").password("admin").roles("admin"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("admin" ,"barista")
			.antMatchers("/users").hasRole("admin")
			.antMatchers("/productDetails").hasAnyRole("admin" ,"barista")
			.antMatchers("/productDetails/{page}").hasAnyRole("admin" ,"barista")
			.antMatchers("/productDetails/**").hasRole("admin")
			.antMatchers("/orders").hasAnyRole("admin" ,"barista")
			.antMatchers("/orders/**").hasRole("barista")
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
				.logout();
	}

	
}
