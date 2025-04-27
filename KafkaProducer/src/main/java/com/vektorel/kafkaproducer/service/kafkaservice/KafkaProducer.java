package com.vektorel.kafkaproducer.service.kafkaservice;

import com.vektorel.kafkaproducer.dto.KargoKafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, KargoKafkaDto> kafkaTemplate;
    static int sayi=0;

    public void sendKafka(String topicName){
        KargoKafkaDto kafkaDto = new KargoKafkaDto();
        kafkaDto.setId("1"+sayi++);
        kafkaDto.setAddress("ankara");
        kafkaDto.setPrice((int) (10+ Math.random()));
        kafkaDto.setCustomerName("furkan");
        kafkaDto.setCustomerPhone("555555555");
        kafkaDto.setCustomerEmail("f@gmail.com");
        kafkaDto.setKargoCompany("mng");

        kafkaTemplate.send(topicName,kafkaDto.getId(),kafkaDto);

    }



}
