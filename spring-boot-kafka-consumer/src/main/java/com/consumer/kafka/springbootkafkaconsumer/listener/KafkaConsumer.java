package com.consumer.kafka.springbootkafkaconsumer.listener;

import com.consumer.kafka.springbootkafkaconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka_string", groupId = "group_id")
    public void consume(String msg) {
        System.out.println("Consumed message: " + msg);
    }

    @KafkaListener(topics = "kafka_json", groupId = "group_json", containerFactory = "userKafkaListener")
    public void consumeJson(User user) {
        System.out.println("Consume json msg: " + user);
    }

}
