package com.hari.cloud.service;

import com.hari.cloud.dto.MobilesDto;
import com.hari.cloud.fiegnclient.OnlineMobilesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineMobilesService {

    @Autowired
    private OnlineMobilesClient onlineMobilesClient;

    public List<MobilesDto> getMobileDetails() {
        return List.of(
           new MobilesDto("Apple", "iPhone 14", "Black", 999.99),
           new MobilesDto("Samsung", "Galaxy S23", "White", 799.99),
           new MobilesDto("Google", "Pixel 7", "Blue", 599.99)
        );
    }

    public List<MobilesDto> getOnlineMobiles() {
        return onlineMobilesClient.getMobileDetails();
    }
}
