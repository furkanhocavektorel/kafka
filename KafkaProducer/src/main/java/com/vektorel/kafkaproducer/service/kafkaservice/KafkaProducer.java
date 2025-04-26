package com.vektorel.kafkaproducer.service.kafkaservice;

import com.vektorel.kafkaproducer.dto.KargoKafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, KargoKafkaDto> kafkaTemplate;


    public void sendKafka(String topicName){
        KargoKafkaDto kafkaDto = new KargoKafkaDto();
        kafkaDto.setId("1");
        kafkaDto.setAddress("ankara");
        kafkaDto.setPrice(5670);
        kafkaDto.setCustomerName("furkan");
        kafkaDto.setCustomerPhone("555555555");
        kafkaDto.setCustomerEmail("f@gmail.com");
        kafkaDto.setKargoCompany("mng");

        kafkaTemplate.send(topicName,kafkaDto.getId(),kafkaDto);

    }



}
