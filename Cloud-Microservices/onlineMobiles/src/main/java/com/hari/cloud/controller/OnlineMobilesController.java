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
@RequestMapping("/online-mobiles")
public class OnlineMobilesController {

    private static final Logger logger = LoggerFactory.getLogger(OnlineMobilesController.class);

    @Autowired
    private OnlineMobilesService onlineMobilesService;

    @GetMapping("/mobiles")
    public ResponseEntity<List<MobilesDto>> getMobileDetails() {
        logger.info("Fetching mobile details");
        return ResponseEntity.ok(onlineMobilesService.getMobileDetails());
    }
}
