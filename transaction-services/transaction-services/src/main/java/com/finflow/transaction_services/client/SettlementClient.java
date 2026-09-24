package com.finflow.transaction_services.client;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class SettlementClient {

    private final RestClient restClient;
    private final HttpServletRequest request;

    public SettlementClient(
            @LoadBalanced RestClient.Builder restClientBuilder,
            HttpServletRequest request) {

        this.restClient = restClientBuilder.build();
        this.request = request;
    }
}