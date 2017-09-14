/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.boot.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.HeaderBuilder;
import org.springframework.security.config.web.server.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

/**
 *
 * @author Yang
 */
@EnableWebFluxSecurity
public class SecurityConfig {

    //https://github.com/spring-projects/spring-security/blob/5.0.0.M2/samples/javaconfig/hellowebflux/src/main/java/sample/UserController.java
    @Bean
    SecurityWebFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {

        SecurityWebFilterChain securityWebFilterChain;

        HttpSecurity httpSecurity = http
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/index").hasRole("ADMIN")
                .pathMatchers("/admin/**").hasRole("ADMIN")
                .pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)
                .anyExchange().authenticated()
                .and();

        HeaderBuilder headerBuilder = httpSecurity.headers();

        headerBuilder.frameOptions().disable();
        
        headerBuilder.contentTypeOptions().disable();

        securityWebFilterChain = httpSecurity.build();

        return securityWebFilterChain;
    }

    private Mono<AuthorizationDecision> currentUserMatchesPath(Mono<Authentication> authentication, AuthorizationContext context) {
        return authentication
                .map(a -> context.getVariables().get("user").equals(a.getName()))
                .map(granted -> new AuthorizationDecision(granted));
    }

    @Bean
    public MapUserDetailsRepository userDetailsRepository() {
        UserDetails rob = User.withUsername("rob").password("rob").roles("USER").build();
        UserDetails admin = User.withUsername("admin").password("admin").roles("USER", "ADMIN").build();
        return new MapUserDetailsRepository(rob, admin);
    }
}
