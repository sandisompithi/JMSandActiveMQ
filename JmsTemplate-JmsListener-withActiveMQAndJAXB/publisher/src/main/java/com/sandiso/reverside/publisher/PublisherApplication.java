package com.sandiso.reverside.publisher;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import com.sandiso.orders.Product;

@SpringBootApplication
public class PublisherApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${outbound.endpoint}")
	private String destination;

	@Override
	public void run(String... args) throws Exception {
		
		Product product = new Product();
		product.setProductId(UUID.randomUUID().toString());
		product.setProductName("Sandiso Mpithi");
		
		jmsTemplate.convertAndSend(destination, product);
		
	}

	
}
