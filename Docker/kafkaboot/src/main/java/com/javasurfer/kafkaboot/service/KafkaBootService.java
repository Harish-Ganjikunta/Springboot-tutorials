package com.javasurfer.kafkaboot.service;

import com.javasurfer.kafkaboot.dto.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaBootService {

    Logger log = LoggerFactory.getLogger(KafkaBootService.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public String sendTopic(Account account){
        log.info("inside KafkaBootService::sendTopic: "+account.toString());
        kafkaTemplate.send("account",account);
        log.info("sent to kafka topic...");
        return "Sent to Kafka Topic with details: "+account.toString();
    }
    public String sendToKafka(String name){
        log.info("inside KafkaBootService::sendTopic: "+name);
        kafkaTemplate.send("account",name);
        log.info("sent to kafka topic...");
        return "Sent to Kafka Topic with details: "+name;
    }
}
