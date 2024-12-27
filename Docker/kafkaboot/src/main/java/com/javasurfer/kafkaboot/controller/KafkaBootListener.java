package com.javasurfer.kafkaboot.controller;

import com.javasurfer.kafkaboot.dto.Account;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaBootListener {

    Logger log = LoggerFactory.getLogger(KafkaBootListener.class);

    @KafkaListener(topics = "account",groupId = "group-1")
    public void consume(@Payload Account account, ConsumerRecord<String,Account> consumerRecord){

        log.info("Inside KafkaBootListener::Consume: "+consumerRecord.toString());
    }
}
