package com.javasurfer.controller;

import com.javasurfer.dto.Person;
import com.javasurfer.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaPublisherController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable  String message) {
        try{
            /*for(int i=0;i<=10000;i++) {
                kafkaProducerService.sendMessage(message+" : "+i);
            }*/
            kafkaProducerService.sendMessage(message);
            return  ResponseEntity.status(HttpStatus.OK).body("Message published successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while publishing message");
        }
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Person person){
       log.info("Inside publish method");
        try{
            kafkaProducerService.sendEventsToTopic(person);
            log.info("Person Message published successfully");
            return  ResponseEntity.status(HttpStatus.OK).body("Person Message published successfully");
        }catch (Exception e){
            log.error("Error while publishing Person message :{}",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while publishing Person message");
        }

    }
}
