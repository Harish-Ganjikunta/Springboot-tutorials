package com.hari.cloud.controller;

import com.hari.cloud.dto.MobilesDto;
import com.hari.cloud.service.OnlineMobilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/online-shopping")
public class OnlineShoppingController {
 private static final Logger log = LoggerFactory.getLogger(OnlineShoppingController.class);
    @Autowired
    private OnlineMobilesService onlineMobilesService;
    @GetMapping("/namskaram")
    public String namskaram(){
        log.info("Inside OnlineShoppingController::namskaram() Namskaram endpoint called");
        return "Namskaram from OnlineShoppingController";
    }

    @GetMapping("/mobiles")
    public ResponseEntity<List<MobilesDto>> getMobileDetails() {
        log.info("Inside OnlineShoppingController::getMobileDetails() Fetching mobile details");
        return ResponseEntity.ok(onlineMobilesService.getMobileDetails());
    }

    @GetMapping("/online-mobiles")
    public ResponseEntity<List<MobilesDto>> getOnlineMobileDetails() {
        log.info("Inside OnlineShoppingController::getOnlineMobileDetails() Fetching online mobile details from the service");
        return ResponseEntity.ok(onlineMobilesService.getOnlineMobiles());
    }
}
