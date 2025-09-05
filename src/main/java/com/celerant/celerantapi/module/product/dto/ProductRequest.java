package com.celerant.celerantapi.module.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ProductRequest {

    @NotNull(message = "Store ID cannot be null")
    @Min(value = 1, message = "Store ID must be greater than 0")
    private Integer store;

    private LocalDateTime lastUpdated;

    @Min(value = 0, message = "Page must be 0 or greater")
    private Integer page = 0;

    @Min(value = 1, message = "Page size must be greater than 0")
    private Integer pageSize = 50;

    // Constructors
    public ProductRequest() {
    }

    public ProductRequest(Integer store, LocalDateTime lastUpdated, Integer page,
                          Integer pageSize) {
        this.store = store;
        this.lastUpdated = lastUpdated;
        this.page = page != null ? page : 0;
        this.pageSize = pageSize != null ? pageSize : 50;
    }

    // Getters and setters
    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

