/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.webflux;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Yang
 */
@Repository
public class UserRepository {

    private final List<User> users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));

    public Mono<User> getUserById(String id) {
        return Mono.justOrEmpty(users.stream().filter(user -> {
            return user.getId().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }

    public Flux<User> getUsers() {
        return Flux.fromIterable(users);
    }
}
