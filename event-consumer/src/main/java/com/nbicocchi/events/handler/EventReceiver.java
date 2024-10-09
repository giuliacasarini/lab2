package com.nbicocchi.events.handler;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EventReceiver {
    @RabbitListener(queues = "eventQueue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

}
