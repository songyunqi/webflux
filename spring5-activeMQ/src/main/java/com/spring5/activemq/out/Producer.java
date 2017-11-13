/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.activemq.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yang
 */
@Service("Producer")
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    /**
     * 广播域，topic
     */
    @Value("${multicast-domain}")
    private String multicastDomain;

    /**
     * 向指定消息域发送消息
     *
     * @param destination
     * @param message
     */
    public void sendMessage(String destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 向广播域发送消息
     *
     * @param message
     */
    public void sendMessage(final String message) {
        jmsTemplate.convertAndSend(multicastDomain, message);
    }

    /**
     * 回音消息，确认消息
     *
     * @param text
     */
    @JmsListener(destination = "${echo-domain}")
    public void echo(String text) {
        System.out.println("从echo队列收到的回复报文为:" + text);
    }
}
