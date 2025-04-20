package com.project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@Configuration
public class GatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("admin-service", r -> r.path("/admins/**")
                .uri("http://localhost:8000"))
            .route("enseignant-service", r -> r.path("/enseignants/**")
                .uri("http://localhost:8001"))
            .route("etudiant-service", r -> r.path("/etudiants/**")
                .uri("http://localhost:8002"))
            .route("module-service", r -> r.path("/modules/**")
                .uri("http://localhost:8044"))
            .route("note-service", r -> r.path("/notes/**")
                .uri("http://localhost:8070"))
            .build();
    }
}
