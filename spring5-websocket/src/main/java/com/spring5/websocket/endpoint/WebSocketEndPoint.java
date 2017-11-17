/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.websocket.endpoint;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yang
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketEndPoint {
    
    private static CopyOnWriteArraySet<WebSocketEndPoint> webSocketSet = new CopyOnWriteArraySet<WebSocketEndPoint>();
}
