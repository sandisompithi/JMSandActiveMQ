package com.sandiso.reverside.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

import com.sandiso.orders.Product;

@SpringBootApplication
public class ConsumerApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@JmsListener(destination = "${inbound.endpoint}")
	public void process(Product product) {
		log.info("Product {} ", product);
	}
}
