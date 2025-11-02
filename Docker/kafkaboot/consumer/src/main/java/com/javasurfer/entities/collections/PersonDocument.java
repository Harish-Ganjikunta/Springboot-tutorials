package com.javasurfer.entities.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDocument {

    private int id;

    private String name;

    private String email;

    private String phone;

    private String address;
}
