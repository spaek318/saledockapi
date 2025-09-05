package com.celerant.celerantapi.module.product.controller;

import com.celerant.celerantapi.common.exception.BusinessException;
import com.celerant.celerantapi.module.product.dto.ProductRequest;
import com.celerant.celerantapi.common.dto.PagedResponse;
import com.celerant.celerantapi.module.product.dto.ProductResponse;
import com.celerant.celerantapi.module.product.service.ProductService;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ProductResponse>> getProducts(
            @RequestParam("store")
            @Min(value = 1, message = "Store ID must be greater than 0")
            Integer store,

            @RequestParam(value = "lastUpdated", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime lastUpdated,

            @RequestParam(value = "page", defaultValue = "0")
            @Min(value = 0, message = "Page must be 0 or greater")
            Integer page,

            @RequestParam(value = "pageSize", defaultValue = "50")
            @Min(value = 1, message = "Page size must be greater than 0")
            Integer pageSize) throws BusinessException {

        logger.info("GET /product/- store: {}, lastUpdated: {}, page: {}, pageSize: {}", store, lastUpdated, page, pageSize);

        try {
            // Create request DTO
            ProductRequest request = new ProductRequest(store, lastUpdated, page, pageSize);

            // Call service
            PagedResponse<ProductResponse> response = productService.getProducts(request);

            logger.info("Successfully returned {} products for store: {}",
                    response.getContent().size(), store);

            return ResponseEntity.ok(response);

        } catch (BusinessException e) {
            logger.error("Business error getting products: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error getting products", e);
            throw new BusinessException("Failed to retrieve products", e);
        }
    }


    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(
            @PathVariable String productId) throws BusinessException {

        logger.info("GET /product/{} - productId: {}", productId, productId);

        try {
            ProductResponse product = productService.getProductById(productId);
            return ResponseEntity.ok(product);

        } catch (BusinessException e) {
            logger.error("Business error getting product {}: {}", productId,
                    e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error getting product: {}", productId, e);
            throw new BusinessException("Failed to retrieve product", e);
        }
    }

    @PostMapping("/cache/clear")
    public ResponseEntity<String> clearCache() throws BusinessException {
        logger.info("POST /Product/v2/cache/clear - clearing product cache");

        try {
            productService.clearProductCache();
            return ResponseEntity.ok("Product cache cleared successfully");

        } catch (Exception e) {
            logger.error("Error clearing product cache", e);
            throw new BusinessException("Failed to clear cache", e);
        }
    }
}

