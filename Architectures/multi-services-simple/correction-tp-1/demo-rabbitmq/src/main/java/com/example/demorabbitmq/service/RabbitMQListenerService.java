package com.example.demorabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListenerService {

    @RabbitListener(queues = {"demo.queue-demo"})
    public void getDataFromQueue(String data) {
        System.out.println(data);
    }

}
