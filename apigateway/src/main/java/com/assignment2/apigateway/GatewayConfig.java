// package com.assignment2.apigateway;

// import java.net.URI;
// import java.util.Random;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cloud.gateway.route.RouteLocator;
// import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class GatewayConfig {

//     // @Autowired
//     // CustomPropertyBean customPropertyBean;

//     @Bean
//     public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        
//         // int weight = customPropertyBean.getWeight();
//         // System.out.println(weight);

//         return builder.routes()
//             // Route 1: weight_high
//             .route("userserviceV1",r -> r
//                     .uri("http://localhost:8080")
//                     .predicate(p -> p.header("Weight", "group1").equalTo("8"))
//             )
//             // Route 2: weight_low
//             .route("userserviceV2",r -> r
//                     .uri("http://localhost:8082")
//                     .predicate(p -> p.header("Weight", "group1").equalTo("2"))
//             )

//             // Configure routing for Order Service
//             .route("orderservice", r -> r
//                 .path("/orderservice/**")
//                 .uri("http://localhost:8081")
//             )
//             .build();
//     }
// }






