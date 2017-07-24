/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.boot.webflux;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *
 * @author Yang
 */
@Service
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> handleGetUsers(ServerRequest request) {
        System.err.println("handleGetUsers");
        return ServerResponse.ok().body(userRepository.getUsers(), User.class);
    }

    public Mono<ServerResponse> handleGetUserById(ServerRequest request) {
        System.err.println("handleGetUserById");
        return userRepository.getUserById(request.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> index(ServerRequest request) {
        System.err.println("index");
        Map<String, Object> params = new HashMap<>();
        params.put("name", "hello world");
        return ServerResponse.ok().render("/index", params);
    }

//    public Mono<Map<String, String>> principal(Principal principal) {
//        return principal(Mono.just(principal));
//    }
}
