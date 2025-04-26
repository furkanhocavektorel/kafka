package com.vektorel.kafkaproducer.controller;

import com.vektorel.kafkaproducer.config.KafkaConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("kafka-admin")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaConfig kafkaConfig;


    @PostMapping("create-topic")
    public void createTopic(@RequestParam String topicName, @RequestParam int partitions, @RequestParam short replication) {
        kafkaConfig.createTopic(topicName, partitions, replication);
    }

    @GetMapping("list-topic")
    public Set<String> listTopic() {
        return kafkaConfig.listTopics();
    }


}
