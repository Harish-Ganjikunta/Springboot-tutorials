package com.hari.cloud.service;

import com.hari.cloud.dto.MobilesDto;
import com.hari.cloud.fiegnclient.OnlineMobilesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineMobilesService {

    private static final Logger log = LoggerFactory.getLogger(OnlineMobilesService.class);
    @Autowired
    private OnlineMobilesClient onlineMobilesClient;

    public List<MobilesDto> getMobileDetails() {
        log.info("Inside OnlineMobilesService::getMobileDetails() Fetching mobile details from the service");
        return List.of(
           new MobilesDto("Apple", "iPhone 14", "Black", 999.99),
           new MobilesDto("Samsung", "Galaxy S23", "White", 799.99),
           new MobilesDto("Google", "Pixel 7", "Blue", 599.99)
        );
    }

    public List<MobilesDto> saveMobileDetails(List<MobilesDto> mobiles) {
        log.info("Inside OnlineMobilesService::saveMobileDetails() Saving mobile details");

       List<MobilesDto> existingMobiles = getMobileDetails();
       existingMobiles.addAll(mobiles);
        return existingMobiles;
    }
    public List<MobilesDto> getOnlineMobiles() {
        log.info("Inside OnlineMobilesService::getOnlineMobiles() Fetching online mobile details from the Feign client");
        return onlineMobilesClient.getMobileDetails();
    }
}
