package com.hari.cloud.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "mobiles")
public class MobilesDto {
    @Id
    private long id;


    @NotNull
    @Size(min = 2, max = 50, message = "Brand name must be between 2 and 50 characters")
    @Indexed(unique = true)
    private String brand;

    @NotNull
    @Size(min = 2, max = 50, message = "Model name must be between 2 and 50 characters")
    @Indexed(unique = true)
    private String model;

    @NotNull
    @Size(min = 2, max = 20, message = "Color must be between 2 and 20 characters")
    @Indexed(unique = true)
    private String color;

    @NotNull
    @Size(min = 1, message = "Price must be greater than 0")
    @Indexed(unique = true)
    private double price;

    public MobilesDto() {
    }

    public MobilesDto(String brand, String model, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
    }

}
