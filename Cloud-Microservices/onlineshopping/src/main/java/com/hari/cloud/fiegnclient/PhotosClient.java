package com.hari.cloud.fiegnclient;

import com.hari.cloud.dto.Photos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.ref.PhantomReference;
import java.util.List;

@FeignClient(name = "photos-service", url = "https://jsonplaceholder.typicode.com")
public interface PhotosClient {

    @GetMapping("/photos")
    List<Photos> getPhotosDetails();
}
