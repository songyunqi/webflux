/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.websocket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 *
 * @author Yang
 */
public class SystemWebSocketHandler implements WebSocketHandler {

    private static final Map<String, WebSocketSession> USERS = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("ConnectionEstablished");
        USERS.put(session.getId(), session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("handleMessage" + message.toString());
        session.sendMessage(new TextMessage(new Date() + ""));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        USERS.remove(session.getId());
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        USERS.remove(session.getId());
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
