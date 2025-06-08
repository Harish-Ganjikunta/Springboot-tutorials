package com.hari.cloud.fiegnclient;

import com.hari.cloud.dto.TodosDto;
import com.hari.cloud.dto.TodosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "todos-service", url = "https://dummyjson.com")
public interface TodosClient {
    @GetMapping("/todos")
    TodosResponse getTodosDetails();
}
