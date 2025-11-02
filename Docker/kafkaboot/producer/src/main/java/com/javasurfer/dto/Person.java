package com.javasurfer.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
