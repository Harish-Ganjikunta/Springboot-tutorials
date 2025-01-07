package com.javasurfer.controller;

import com.javasurfer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaPublisherController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable  String message) {
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
}
