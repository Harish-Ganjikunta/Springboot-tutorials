package com.hari.cloud.service;

import com.hari.cloud.dto.TodosDto;
import com.hari.cloud.dto.TodosResponse;
import com.hari.cloud.fiegnclient.TodosClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosService {

    @Autowired
    private TodosClient todosClient;

    public TodosResponse getTodosDetails() {
        return todosClient.getTodosDetails();
    }
}
