package com.example.demorabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("")
    public ResponseEntity<String> send(@RequestParam String data) {
        rabbitTemplate.convertAndSend("demo.queue-demo", data);
        return ResponseEntity.ok("Ok");
    }
}
