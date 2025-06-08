package com.hari.cloud.controller;

import com.hari.cloud.dto.MobilesDto;
import com.hari.cloud.service.OnlineMobilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/online-shopping")
public class OnlineShoppingController {

    @Autowired
    private OnlineMobilesService onlineMobilesService;
    @GetMapping("/namskaram")
    public String Namskaram(){
        return "Namskaram from OnlineShoppingController";
    }

    @GetMapping("/mobiles")
    public ResponseEntity<List<MobilesDto>> getMobileDetails() {
        return ResponseEntity.ok(onlineMobilesService.getMobileDetails());
    }

    @GetMapping("/online-mobiles")
    public ResponseEntity<List<MobilesDto>> getOnlineMobileDetails() {
        return ResponseEntity.ok(onlineMobilesService.getOnlineMobiles());
    }
}
