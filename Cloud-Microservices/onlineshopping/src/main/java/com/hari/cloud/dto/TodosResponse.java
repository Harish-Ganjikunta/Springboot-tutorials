package com.hari.cloud.dto;

import java.util.List;

public class TodosResponse {

    private List<TodosDto> todos;
    private int total;
    private int skip;
    private int limit;

    public List<TodosDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodosDto> todos) {
        this.todos = todos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
