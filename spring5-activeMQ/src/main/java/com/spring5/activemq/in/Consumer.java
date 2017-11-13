/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.activemq.in;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yang
 */
@Component
public class Consumer {

    /**
     * 消费信息
     *
     * @param text
     * @return
     */
    @JmsListener(destination = "${multicast-domain}")
    @SendTo("${echo-domain}")
    public String receiveMessage(String text) {
        return "return message" + text;
    }
}
