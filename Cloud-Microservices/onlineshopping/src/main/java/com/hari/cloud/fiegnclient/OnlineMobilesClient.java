package com.hari.cloud.fiegnclient;

import com.hari.cloud.dto.MobilesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "online-mobiles", url = "http://localhost:8089/online-mobiles")
public interface OnlineMobilesClient {

    @GetMapping("/mobiles")
    List<MobilesDto> getMobileDetails();

    @PostMapping("/mobiles")
    List<MobilesDto> saveMobileDetails(@RequestBody MobilesDto mobile);
}
