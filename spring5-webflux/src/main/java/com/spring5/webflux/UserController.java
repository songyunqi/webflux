/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.webflux;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Yang
 */
//@Controller
public class UserController {

    @GetMapping("/userView")
    public String index() {
        return "test";
    }
}
