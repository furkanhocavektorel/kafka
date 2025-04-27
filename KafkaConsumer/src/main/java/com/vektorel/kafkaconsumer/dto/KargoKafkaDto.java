package com.vektorel.kafkaconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class KargoKafkaDto {

    private String id;
    private String address;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private Integer price;
    private String kargoCompany;
}

