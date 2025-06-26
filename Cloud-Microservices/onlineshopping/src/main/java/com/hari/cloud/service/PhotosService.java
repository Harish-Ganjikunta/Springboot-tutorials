package com.hari.cloud.service;

import com.hari.cloud.dto.Photos;
import com.hari.cloud.fiegnclient.PhotosClient;
import com.hari.cloud.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    @Autowired
    private PhotosClient photosClient;

    @Autowired
    private PhotosRepository photosRepository;
    public List<Photos> getPhotos() {
       List<Photos> photos = photosClient.getPhotosDetails();
       photosRepository.saveAll(photos);
        return photos;
    }
}
