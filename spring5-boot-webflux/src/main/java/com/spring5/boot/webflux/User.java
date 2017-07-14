/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.boot.webflux;

/**
 *
 * @author Yang
 */
public class User {

    public User() {
    }

    public User(Long id, String user) {
        this.id = id;
        this.user = user;
    }

    private Long id;
    private String user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
