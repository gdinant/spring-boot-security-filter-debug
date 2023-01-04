package com.kao.spring.controller;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class ComponentSecurityContext {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
			.addFilterAt(new MyFilter(), BasicAuthenticationFilter.class)
			.authorizeHttpRequests(customizer -> customizer
				.requestMatchers(new AntPathRequestMatcher("/public/**"))
				.permitAll()
				.anyRequest()
				.authenticated())
			.build();
	}

	public static class MyFilter extends OncePerRequestFilter {

		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

			System.out.println("Filter is called for uri: " + request.getRequestURI());

			// performs some authentication

			filterChain.doFilter(request, response);
		}
	}

}
