package com.nbicocchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.baeldung")
@EnableScheduling
public class SpringCloudStreamProducer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamProducer.class, args);
	}

}
