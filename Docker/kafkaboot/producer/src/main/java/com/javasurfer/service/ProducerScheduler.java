package com.javasurfer.service;

import com.github.javafaker.Faker;
import com.javasurfer.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProducerScheduler {

    @Autowired
    private KafkaProducerService kafkaProducerService;


    /*static ArrayList<Integer> idList = null;

    static {
        idList = new ArrayList<>();
        idList.add(0);

    }*/
    @Scheduled(fixedRate = 5000, initialDelay = 5000)
    //@Scheduled(cron = "0 0 12 * * ?") // Executes at 12:00 PM every day
    public void scheduleProducerTask() {
        log.info("Scheduled producer task executed");
        kafkaProducerService.sendEventsToTopic(getPersonDetails());
        log.info("Person details sent to Kafka topic");
    }

    private static Person getPersonDetails(){
      //  Integer i = idList.getLast();
        Person person = new Person();
        //erson.setId(++i);
        String name = getName();
        person.setName(name);
        person.setEmail(name+"@gmail.com");
        person.setPhone(getRandomNum(10));
        person.setAddress(getAddress());
        //idList.add(i);
        return person;
    }

    public static String getRandomNum(int length) {
        SecureRandom random = new SecureRandom();
           String rest = random.ints(length - 1, 0, 10)
                   .mapToObj(Integer::toString)
                   .collect(Collectors.joining());
           return "9" + rest;
    }

    private static String getName(){
        Faker faker = new Faker();
        /*String randomFullName = faker.name().fullName();
        String randomFirstName = faker.name().firstName();
        String randomLastName = faker.name().lastName();*/
        return faker.name().fullName();
    }

    private static String getAddress() {
        Faker faker = new Faker();
        String lat = faker.address().latitude();
        String lon = faker.address().longitude();
        String address = faker.address().streetName();
        return address+ "(" +  lat + "," + lon + ")";
        //return address;
    }

 /*   public static void main(String[] args) {
        //System.out.println(getRandomNum(0));
        System.out.println(getPersonDetails());
    }*/
}
