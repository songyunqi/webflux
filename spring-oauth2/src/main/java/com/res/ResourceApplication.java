/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.res;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yang
 */
@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceApplication {
    
    @RequestMapping("/")
    public Message home() {
        return new Message("Hello World");
    }
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
