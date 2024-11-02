package com.bodkasoft.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("get-route", r -> r.path("/**")
                        .and().method("GET").filters(f -> f.prefixPath("/api/v1"))
                        .uri("http://localhost:8081")
                )
                .build();
    }
}