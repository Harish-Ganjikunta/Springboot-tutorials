package com.javasurfer.service;

import com.javasurfer.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "javasurfer-topic2";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public void sendMessage(String message) {
     CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send(TOPIC, message);

     future.whenComplete((result, ex) -> {
        if (ex == null) {
            System.out.println("Message sent =["+message+ "]with OffSet =["+result.getRecordMetadata().offset()+"] successfully");
        } else {
            System.out.println("Error sending message=["+message+"] with exception=["+ex.getMessage()+"]");
        }
    });
    }

    public void sendEventsToTopic(Person person) {
        CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send(TOPIC, person);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Message sent =["+person.toString()+ "]with OffSet =["+result.getRecordMetadata().offset()+"] successfully");
            } else {
                System.out.println("Error sending message=["+person.toString()+"] with exception=["+ex.getMessage()+"]");
            }
        });
    }
}
