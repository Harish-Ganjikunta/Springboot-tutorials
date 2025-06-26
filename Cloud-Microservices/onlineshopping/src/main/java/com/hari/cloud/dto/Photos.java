package com.hari.cloud.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "photos")
public class Photos {

    @Id
    private Long id;

    @Indexed(unique = true)
    private Long albumId;

    @Indexed(unique = true)
    private String title;

    @Indexed(unique = true)
    private String url;

    @Indexed(unique = true)
    private String thumbnailUrl;


}
