package com.hari.cloud.service;

import com.hari.cloud.dto.Photos;
import com.hari.cloud.fiegnclient.PhotosClient;
import com.hari.cloud.repository.PhotosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    private static final Logger logger = LoggerFactory.getLogger(PhotosService.class);

    @Autowired
    private PhotosClient photosClient;

    @Autowired
    private PhotosRepository photosRepository;

    public List<Photos> fetchPhotos() {
        logger.info("Fetching photos from external service");
        // Fetch photos from the external service using Feign client
       List<Photos> photos = photosClient.getPhotosDetails();
       photosRepository.saveAll(photos);
        return photos;
    }
    public List<Photos> getPhotos() {
        logger.info("Fetching photos from the Mongodb/NoSQL database");
        return photosRepository.findAll();
    }

    public List<Photos> getPhotosByAlbumId(Long albumId) {
        logger.info("Fetching photo by album ID: {}", albumId);
        return photosRepository.findByAlbumId(albumId);

    }

    public Photos getPhotoById(Long id) {
        logger.info("Fetching photo by ID: {}", id);
        return photosRepository.findByPhotoId(id)
                .orElseThrow(() -> new RuntimeException("Photo not found with ID: " + id));
    }
}
