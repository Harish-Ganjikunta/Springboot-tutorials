package com.converters.convertersapp.controllers.rest;

import com.converters.convertersapp.services.PDFConverterService;
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
@RequestMapping("/api/pdf")
public class PDFConverterController {

    @Autowired
    private PDFConverterService pdfConverterService;

    @PostMapping(value = "/v1/pdf-to-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity <?> convertPDFToImage(@RequestParam("file") MultipartFile file, @RequestParam("format") String format, @RequestParam("download") Character download) {
        log.info("Entered into the convertPDFToImage method...");

        return pdfConverterService.generateImageFromPDF(file, format,download);
    }
}
