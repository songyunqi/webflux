/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.web.functional.handler;

import com.spring5.base.domain.User;
import com.spring5.base.rep.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.EntityResponse.fromObject;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *
 * @author Yang
 */
public class UserHandler {

    @Autowired
    private UserRep userRep;

    public Mono<ServerResponse> listPeople(ServerRequest request) {
        
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(null, User.class);
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
       return null;
    }
}
