package com.javasurfer.service;

import com.javasurfer.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private final Logger log = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @Autowired
    private PersonService personService;

    @KafkaListener(topics = "javasurfer-topic1", groupId = "javasurfer-group")
    public void consume(Person person) {
        log.info("Consumed message: {}", person.toString());
        //persist to MONGO DB
       // personService.savePerson(person);
     //persist to MYSQL
        personService.savePersonEntity(person);


    }


  /*  public static void main(String... args) throws JsonProcessingException {
        ObjectMapper mapper =  new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new Person()));
    }*/
}
