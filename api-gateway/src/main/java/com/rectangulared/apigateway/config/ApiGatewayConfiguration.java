package com.rectangulared.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/builder/**")
                        .uri("lb://pizza-builder"))
                .route(p -> p
                        .path("")
                        .uri("lb://pizza-viewer"))
                .route(p -> p
                        .path("/cart/**")
                        .uri("lb://pizza-cart"))
                .build();
    }
}