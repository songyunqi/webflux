/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.webflux;

import java.util.HashMap;
import java.util.Map;
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

    //@Autowired
    UserReactiveRepository userReactiveRepository;

    public Mono<ServerResponse> handleGetUsers(ServerRequest request) {
        return ServerResponse.ok().body(userReactiveRepository.findAll(), User.class);
    }

    public Mono<ServerResponse> handleGetUserById(ServerRequest request) {
        return userReactiveRepository.findOne(Long.valueOf(request.pathVariable("id")))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> userView(ServerRequest request) {
        Map<String, ?> params = new HashMap<>();
        return ServerResponse.ok().render("/userView", params);
    }
}
