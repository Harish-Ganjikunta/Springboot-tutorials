package com.javasurfer.service;

import com.javasurfer.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaProducerService {

    private static final String TOPIC = "javasurfer-topic1";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public void sendMessage(String message) {
     CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send(TOPIC, message);

     future.whenComplete((result, ex) -> {
        if (ex == null) {
            //System.out.println("Message sent =["+message+ "]with OffSet =["+result.getRecordMetadata().offset()+"] successfully");
            log.info("Message sent =[{}]with OffSet =[{}] successfully",message,result.getRecordMetadata().offset());
        } else {
           // System.out.println("Error sending message=["+message+"] with exception=["+ex.getMessage()+"]");
            log.info("Error sending message=[{}] with exception=[{}]",message,ex.getMessage());
        }
    });
    }

    public void sendEventsToTopic(Person person) {
        CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send(TOPIC, person);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                //System.out.println("Message sent =["+person.toString()+ "]with OffSet =["+result.getRecordMetadata().offset()+"] successfully");
                log.info("Message sent =[{}]with OffSet =[{}] successfully",person.toString(),result.getRecordMetadata().offset());
            } else {
                //System.out.println("Error sending message=["+person.toString()+"] with exception=["+ex.getMessage()+"]");
                log.info("Error sending message=[{}] with exception=[{}]",person.toString(),ex.getMessage());
            }
        });
    }
}
