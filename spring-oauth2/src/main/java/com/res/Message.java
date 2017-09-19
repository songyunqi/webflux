/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.res;

import java.util.UUID;

/**
 *
 * @author Yang
 */
public class Message {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String id = UUID.randomUUID().toString();

    private String content;

    public Message(String content) {
        this.content = content;
    }
}
