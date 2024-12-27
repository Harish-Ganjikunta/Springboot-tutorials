package com.javasurfer.kafkaboot.controller;

import com.javasurfer.kafkaboot.dto.Account;
import com.javasurfer.kafkaboot.service.KafkaBootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class KafkaBootController {

    Logger log = LoggerFactory.getLogger(KafkaBootController.class);

    @Autowired
    private KafkaBootService kafkaBootService;

    @PostMapping("/kafka")
    public ResponseEntity<String> publishToKafka(@RequestBody Account account){
        log.info("Inside KafkaBootController::publishToKafka: "+account.toString());
        return ResponseEntity.ok(kafkaBootService.sendTopic(account));
    }

    @GetMapping("/kafka/{name}")
    public ResponseEntity<String> publishToKafka(@PathVariable("name") String name){
        log.info("Inside KafkaBootController::publishToKafka: "+name);
        return ResponseEntity.ok(kafkaBootService.sendToKafka(name));
    }


}
