package com.converters.convertersapp.controllers.rest;

import com.converters.convertersapp.services.ImageConverterService;
import com.converters.convertersapp.utils.ConverterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

@RestController
@Slf4j
@RequestMapping("/api")
public class ImageConverterController {

    @Autowired
    private ImageConverterService imageConverterService;

    @Autowired
    private ConverterUtils converterUtils;

    @PostMapping(value = "/v1/image-to-txt", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> convertImageToText(@RequestParam("image") MultipartFile imageFile, @RequestParam("format") String format) {
        log.info("Entered into the ImageConverterController::convertImageToText...");
        return ResponseEntity.ok(imageConverterService.convert(imageFile, format));
    }

    @PostMapping(value = "/v1/convert-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> convertImage(@RequestParam("file") MultipartFile file, @RequestParam("format") String format) {
        log.info("Entered into the ImageConverterController::convertImage method...");
        return imageConverterService.convertImageToImage(file, format);
    }

    @PostMapping(value = "/v1/image-to-pdf", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> convertImageToPDF(@RequestParam("file") MultipartFile file) {
        log.info("Entered into the ImageConverterController::convertImageToPDF method...{}",file.getName());
        ByteArrayOutputStream byteArrayOutputStream =  imageConverterService.convertImageTextToPDF(file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+converterUtils.extractFileName(file)+".pdf");
        headers.setContentLength(byteArrayOutputStream.size());
        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers,  HttpStatus.OK);
    }

}
