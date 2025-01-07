package com.javasurfer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasurfer.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {
    private final Logger log = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "javasurfer-topic2", groupId = "javasurfer-group")
    public void consume(Person person) {
        log.info("Consumed message: {}", person.toString());
    }


  /*  public static void main(String... args) throws JsonProcessingException {
        ObjectMapper mapper =  new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new Person()));
    }*/
}
