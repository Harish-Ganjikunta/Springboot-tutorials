package com.hari.cloud.controller;

import com.hari.cloud.dto.Photos;
import com.hari.cloud.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PhotosController {

    @Autowired
    private PhotosService photosService;


    @GetMapping("/photos")
    public ResponseEntity<List<Photos>> getPhotos() {
        return ResponseEntity.ok(photosService.getPhotos());
    }

}
