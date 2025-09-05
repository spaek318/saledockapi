package com.celerant.celerantapi.module.product.service;


import com.celerant.celerantapi.common.dto.PagedResponse;
import com.celerant.celerantapi.common.exception.BusinessException;
import com.celerant.celerantapi.module.product.dto.ProductRequest;
import com.celerant.celerantapi.module.product.dto.ProductResponse;
import com.celerant.celerantapi.module.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private  ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    @Cacheable(value = "productCache", key="#p0", condition="#p0!=null")//key = "#customerId")//, unless = "#result.isEmpty()")
    //@Cacheable(value = "productCache", key = "#request.store + '_' + #request.page + '_' + #request.pageSize + '_' + #request.lastUpdated")
    public PagedResponse<ProductResponse> getProducts(ProductRequest request) throws BusinessException {
        logger.info("Fetching products for store: {}, page: {}, pageSize: {}",
                request.getStore(), request.getPage(), request.getPageSize());

        try {
            // Create pageable with sorting
            Sort sort = Sort.by(Sort.Direction.ASC, "name");
            Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(),
                    sort);

            // Fetch data from repository
            Page<Object[]> resultPage = productRepository.findProductsByStoreAndLastUpdated(
                    request.getStore(),
                    request.getLastUpdated(),
                    pageable
            );

            // Convert Object[] results to ProductResponse DTOs
            List<ProductResponse> products = resultPage.getContent().stream()
                    .map(this::mapToProductResponse)
                    .collect(Collectors.toList());

            // Create paged response
            PagedResponse<ProductResponse> response = new PagedResponse<>();
            response.setContent(products);
            response.setPage(request.getPage());
            response.setPageSize(request.getPageSize());
            response.setTotalElements(resultPage.getTotalElements());
            response.setTotalPages(resultPage.getTotalPages());
            response.setFirst(resultPage.isFirst());
            response.setLast(resultPage.isLast());

            logger.info("Successfully fetched {} products for store: {}",
                    products.size(), request.getStore());
            return response;

        } catch (Exception e) {
            logger.error("Error fetching products for store: {}", request.getStore(), e);
            throw new BusinessException("Failed to retrieve products", e);
        }
    }

    @Override
    @Cacheable(value = "productSingleCache", key = "#productId")
    public ProductResponse getProductById(String productId) throws BusinessException {
        logger.info("Fetching product by ID: {}", productId);

        try {
            UUID uuid = UUID.fromString(productId);
            // Implementation for single product retrieval would go here
            // This is a simplified version - you'd need to modify the query
        } catch (IllegalArgumentException e) {
            throw new BusinessException("Invalid product ID format: " + productId, e);
        } catch (Exception e) {
            logger.error("Error fetching product by ID: {}", productId, e);
            throw new BusinessException("Failed to retrieve product", e);
        }
        //TODO : fixit
        return null;
    }

    @Override
    @CacheEvict(value = {"productCache", "productSingleCache"}, allEntries = true)
    public void clearProductCache() {
        logger.info("Clearing all product caches");
    }

    /**
     * Maps database result Object[] to ProductResponse DTO
     */
    private ProductResponse mapToProductResponse(Object[] result) {
        ProductResponse product = new ProductResponse();

        // Map according to the SELECT query order
        //product.setPk(result[0] != null ? (UUID) result[0] : null);
        product.setName(result[1] != null ? result[1].toString() : null);
        product.setSku(result[2] != null ? result[2].toString() : null);
        product.setCat(result[3] != null ? result[3].toString() : null);
        product.setCid(result[4] != null ? result[4].toString() : null);
        product.setSub(result[5] != null ? result[5].toString() : null);
        product.setSid(result[6] != null ? result[6].toString() : null);
        product.setSup(result[7] != null ? result[7].toString() : null);
        product.setBrand(result[8] != null ? result[8].toString() : null);
        product.setTax(result[9] != null ? (BigDecimal) result[9] : BigDecimal.ZERO);
        product.setQuick(result[10] != null ? result[10].toString() : "true");
        product.setTile(result[11] != null ? result[11].toString() : null);
        //product.setVer(result[12] != null ? (UUID) result[12] : null);
        product.setLoy(result[13] != null ? result[13].toString() : "true");
        product.setCloy(result[14] != null ? result[14].toString() : "true");
        product.setLp(result[15] != null ? (Integer) result[15] : 1);
        product.setOpt1(result[16] != null ? result[16].toString() : null);
        product.setOpt2(result[17] != null ? result[17].toString() : null);
        product.setTp(result[18] != null ? result[18].toString() : null);
        product.setSn(result[19] != null ? result[19].toString() : "true");
        product.setD(result[20] != null ? result[20].toString() : null);
        product.setS(result[21] != null ? result[21].toString() : null);

        return product;
    }
}

