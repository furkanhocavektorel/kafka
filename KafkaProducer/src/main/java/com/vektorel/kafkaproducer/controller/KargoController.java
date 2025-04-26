package com.vektorel.kafkaproducer.controller;

import com.vektorel.kafkaproducer.service.kafkaservice.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("kargo")
public class KargoController {
    private final KafkaProducer kafkaProducer;



    @PostMapping("send-kafka")
    public void send(@RequestParam String topicName){
        kafkaProducer.sendKafka(topicName);
    }


}
