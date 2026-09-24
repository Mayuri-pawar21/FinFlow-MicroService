package com.finflow.apigateway.security;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter  implements GlobalFilter, Ordered {

	 @Override
	    public Mono<Void> filter(ServerWebExchange exchange,
	                             GatewayFilterChain chain) {
		 String path = exchange.getRequest().getURI().getPath();

		 if (path.startsWith("/api/auth/")) {
		     return chain.filter(exchange);
		 }

		 if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
		     return chain.filter(exchange);
		 }

		 String authHeader = exchange.getRequest()
		         .getHeaders()
		         .getFirst(HttpHeaders.AUTHORIZATION);

	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
	            return exchange.getResponse().setComplete();
	        }

	        String token = authHeader.substring(7);

	        if (!JwtUtil.validateToken(token)) {
	            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
	            return exchange.getResponse().setComplete();
	        }

	        String email = JwtUtil.getEmail(token);
	        String role = JwtUtil.getRole(token);

	        if (role != null && role.startsWith("ROLE_")) {
	            role = role.substring(5);
	        }

	        System.out.println(">>> Gateway Email: " + email);
	        System.out.println(">>> Gateway Role: " + role);

	        ServerHttpRequest request = exchange.getRequest()
	                .mutate()
	                .header("X-User-Email", email)
	                .header("X-User-Role", role)
	                .build();

	        return chain.filter(exchange.mutate().request(request).build());
	    }

	    @Override
	    public int getOrder() {
	        return -1;
	    }
}
