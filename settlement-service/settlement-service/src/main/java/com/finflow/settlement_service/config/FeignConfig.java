package com.finflow.settlement_service.config;

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

                String authorization =
                        request.getHeader("Authorization");

                String userEmail =
                        request.getHeader("X-User-Email");

                String userRole =
                        request.getHeader("X-User-Role");

                if (authorization != null) {
                    requestTemplate.header(
                            "Authorization",
                            authorization);
                }

                if (userEmail != null) {
                    requestTemplate.header(
                            "X-User-Email",
                            userEmail);
                }

                if (userRole != null) {
                    requestTemplate.header(
                            "X-User-Role",
                            userRole);
                }
            }
        };
    }
}