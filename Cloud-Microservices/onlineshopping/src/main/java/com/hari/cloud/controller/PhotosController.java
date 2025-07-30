package com.hari.cloud.controller;

import com.hari.cloud.dto.Photos;
import com.hari.cloud.service.PhotosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PhotosController {
    private static final Logger logger = LoggerFactory.getLogger(PhotosController.class);
    @Autowired
    private PhotosService photosService;


    @GetMapping("/photos")
    public ResponseEntity<List<Photos>> getPhotos() {
        logger.info("Inside PhotosController::getPhotos() Received request to fetch photos");
        return ResponseEntity.ok(photosService.getPhotos());
    }

    @GetMapping("/photos/album/{albumId}")
    public ResponseEntity<List<Photos>> getPhotosByAlbumId(@PathVariable(name = "albumId") Long albumId) {
        logger.info("Inside PhotosController::getPhotosByAlbumId() Received request to fetch photos by album ID: {}", albumId);
        return ResponseEntity.ok(photosService.getPhotosByAlbumId(albumId));
    }

    @GetMapping("/photos/{id}")
    public ResponseEntity<Photos> getPhotoById(@PathVariable(name = "id") Long id) {
        logger.info("Inside PhotosController::getPhotoById()Received request to fetch photo by ID: {}", id);
        return ResponseEntity.ok(photosService.getPhotoById(id));
    }

}
