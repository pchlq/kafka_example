package com.producer.kafka.springbootkafkaproducer.controller;

import com.producer.kafka.springbootkafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserRestController {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private final static String TOPIC = "kafka_producer_example";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, 500L));
        return "Published Successfully";
    }
}
