package com.celerant.celerantapi.module.product.service;


import com.celerant.celerantapi.common.dto.PagedResponse;
import com.celerant.celerantapi.common.exception.BusinessException;
import com.celerant.celerantapi.module.product.dto.ProductRequest;
import com.celerant.celerantapi.module.product.dto.ProductResponse;

public interface ProductService {
    PagedResponse<ProductResponse> getProducts(ProductRequest request) throws BusinessException;

    ProductResponse getProductById(String productId) throws BusinessException;

    void clearProductCache();
}
