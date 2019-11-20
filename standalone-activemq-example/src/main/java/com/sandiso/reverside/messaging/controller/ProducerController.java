package com.sandiso.reverside.messaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;


@RestController    // Used to create RESTful web services using Spring MVC
@RequestMapping("/rest/publish")
public class ProducerController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") // to bind the URI template variables to the handler method parameters
                          final String message) {
        jmsTemplate.convertAndSend(queue, message);
        return "Published Successfully";
    }
}
