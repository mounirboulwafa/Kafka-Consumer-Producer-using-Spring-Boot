package com.boulwafa.kafkaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic = "kafka-consumer-producer-topic";

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable String message) {
        kafkaTemplate.send(topic, message);
        return "Message Published";
    }
}
