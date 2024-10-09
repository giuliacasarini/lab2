package com.nbicocchi.events.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.UUID;
import java.util.random.RandomGenerator;



@Component
public class EventSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final Logger LOG = LoggerFactory.getLogger(EventSender.class);

    public EventSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void randomMessage() {
        sendMessage("eventQueue", UUID.randomUUID().toString());
    }

    private void sendMessage(String queueName, String event) {
        LOG.debug("Sending message {} to {}", event, queueName);
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend(queueName, event);
        }
    }
}
