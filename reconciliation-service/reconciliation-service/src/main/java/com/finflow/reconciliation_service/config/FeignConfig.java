package com.finflow.reconciliation_service.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {

        return requestTemplate -> {

            ServletRequestAttributes attributes =
                    (ServletRequestAttributes)
                            RequestContextHolder.getRequestAttributes();

            if (attributes != null) {

                HttpServletRequest request =
                        attributes.getRequest();

                // Forward Authorization header
                String authorization =
                        request.getHeader("Authorization");

                if (authorization != null) {

                    requestTemplate.header(
                            "Authorization",
                            authorization);
                }

                // Forward user email
                String userEmail =
                        request.getHeader("X-User-Email");

                if (userEmail != null) {

                    requestTemplate.header(
                            "X-User-Email",
                            userEmail);
                }

                // Forward user role
                String userRole =
                        request.getHeader("X-User-Role");

                if (userRole != null) {

                    requestTemplate.header(
                            "X-User-Role",
                            userRole);
                }
            }
        };
    }
}