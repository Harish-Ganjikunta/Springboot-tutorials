package com.converters.convertersapp.controllers.rest;

import com.converters.convertersapp.services.ImageConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/api")
public class ImageConverterController {

    @Autowired
    private ImageConverterService imageConverterService;

    @PostMapping(value = "/v1/convert-to-txt", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> convertImageToText(@RequestParam("image") MultipartFile imageFile, @RequestParam("format") String format) {
        log.info("Entered into the ImageConverterController...");
        return ResponseEntity.ok(imageConverterService.convert(imageFile, format));
    }

    @PostMapping(value = "/v1/convert-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> convertImage(@RequestParam("file") MultipartFile file, @RequestParam("format") String format) {
        log.info("Entered into the convertImage method...");
        return imageConverterService.convertImageToImage(file, format);
    }

}
