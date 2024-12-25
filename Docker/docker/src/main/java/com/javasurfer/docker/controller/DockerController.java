package com.javasurfer.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping("/hey/{name}")
    private String hey(@PathVariable("name") String name){
        return "hey "+name+" dude";
    }
}
