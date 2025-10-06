package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig 
{
	@Bean
	public SecurityFilterChain sec(HttpSecurity https) throws Exception
	{

		https.
	     authorizeHttpRequests(req 
	    		 -> req
	    		 .requestMatchers("/").permitAll()
	    		 .anyRequest().authenticated())
	    
	    .csrf(i->i.disable())
	    .httpBasic(Customizer.withDefaults());
		return https
				.build();
	}
	
	@Bean
	public UserDetailsService userService()
	{
		
		UserDetails chetan = User
				             .withUsername("chetan")
				             .password("{noop}")
				             .roles("User")
				             .build();
		
		
		UserDetails ajay = User
	             .withUsername("ajay")
	             .password("{noop}pass1")
	             .roles("Admin")
	             .build();
		
				return new InMemoryUserDetailsManager(chetan,ajay);
	}
}