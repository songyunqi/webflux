/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.boot.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
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
    SecurityWebFilterChain springWebFilterChain(HttpSecurity http) throws Exception {
        return http
                //.authorizeExchange().pathMatchers("/**").permitAll()  //不起作用，一样是html字符串输出
                .authorizeExchange()
                .pathMatchers("/index").hasRole("ADMIN")
                .pathMatchers("/admin/**").hasRole("ADMIN")
                .pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)
                .anyExchange().authenticated()
                .and()
                .build();
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
