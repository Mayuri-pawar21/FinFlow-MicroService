package com.finflow.account_service.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderAuthenticationFilter extends OncePerRequestFilter {

	 @Override
	    protected void doFilterInternal(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    FilterChain filterChain)
	            throws ServletException, IOException {

	        String email = request.getHeader("X-User-Email");
	        String role = request.getHeader("X-User-Role");

	        if (email != null && role != null) {

	            UsernamePasswordAuthenticationToken authentication =
	                    new UsernamePasswordAuthenticationToken(
	                            email,
	                            null,
	                            List.of(new SimpleGrantedAuthority("ROLE_" + role)));

	            authentication.setDetails(
	                    new WebAuthenticationDetailsSource().buildDetails(request));

	            org.springframework.security.core.context.SecurityContextHolder
	                    .getContext()
	                    .setAuthentication(authentication);
	        }
	        filterChain.doFilter(request, response);
	    }

}
