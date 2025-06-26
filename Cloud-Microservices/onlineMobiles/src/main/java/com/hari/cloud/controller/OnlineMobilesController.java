package com.hari.cloud.controller;

import com.hari.cloud.dto.MobilesDto;
import com.hari.cloud.service.OnlineMobilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/online-mobiles")
public class OnlineMobilesController {

    private static final Logger logger = LoggerFactory.getLogger(OnlineMobilesController.class);

    @Autowired
    private OnlineMobilesService onlineMobilesService;

    @GetMapping("/mobiles")
    public ResponseEntity<List<MobilesDto>> getAllMobileDetails() {
        logger.info("Fetching all-mobiles details");
        return ResponseEntity.ok(onlineMobilesService.getMobiles());
    }

    @PostMapping("/mobiles")
    public ResponseEntity<MobilesDto> saveMobileDetails(MobilesDto mobilesDto) {
        logger.info("Saving mobile details");
        return ResponseEntity.ok(onlineMobilesService.saveMobileDetails(mobilesDto));
    }

    @GetMapping("/mobiles/{id}")
    public ResponseEntity<MobilesDto> getMobileById(@PathVariable("id") Long id) {
        logger.info("Fetching mobile details by ID: {}", id);
        MobilesDto mobilesDto = onlineMobilesService.getMobileById(id);
        return ResponseEntity.ok(mobilesDto);
    }

    @DeleteMapping("/mobiles/{id}")
    public ResponseEntity<MobilesDto> deleteMobileById(@PathVariable("id") Long id) {
        logger.info("Deleting mobile details by ID: {}", id);
        MobilesDto deletedMobile = onlineMobilesService.deleteMobileById(id);
        return ResponseEntity.ok(deletedMobile);
    }

    @PutMapping("/mobiles")
    public ResponseEntity<MobilesDto> updateMobileDetails(@RequestBody MobilesDto mobilesDto) {
        logger.info("Updating mobile details for ID: {}", mobilesDto.getId());
        MobilesDto updatedMobile = onlineMobilesService.updateMobileDetails(mobilesDto);
        return ResponseEntity.ok(updatedMobile);
    }
}
