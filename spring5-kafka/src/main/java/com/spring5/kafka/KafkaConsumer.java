package com.spring5.kafka;

import org.springframework.kafka.annotation.KafkaListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yang
 */
public class KafkaConsumer {

    /**
     * 监听test主题,有消息就读取 [@param](https://my.oschina.net/u/2303379) message
     *
     * @param message
     */
    @KafkaListener(topics = {"test"})
    public void consume(String message) {
        System.out.println(message);
    }
}
