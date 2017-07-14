/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

/**
 *
 * @author Yang
 */
//@Controller
public class UserController {

    @Autowired
    UserReactiveRepository userRep;

    @GetMapping("/userView")
    public String index() {
        return "test";
    }

    @GetMapping("allUsers")
    @ResponseBody
    public Flux<User> allUsers() {
        return userRep.findAll();
    }
}
