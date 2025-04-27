package com.vektorel.kafkaconsumer.service;

import com.vektorel.kafkaconsumer.dto.KargoKafkaDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "asd")
    public void listen1(ConsumerRecord<String, KargoKafkaDto> mesaj){

        System.out.println("key : "+mesaj.key());
        System.out.println("value : "+mesaj.value());
        System.out.println("customer name: "+mesaj.value().getCustomerName());
        System.out.println("price: "+mesaj.value().getPrice());
        System.out.println("partition : "+mesaj.partition());

    }




}
