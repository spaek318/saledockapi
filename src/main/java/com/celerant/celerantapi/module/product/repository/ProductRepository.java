package com.celerant.celerantapi.module.product.repository;


import com.celerant.celerantapi.module.product.entity.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<Style, Integer> {

    @Query(value = """
            SELECT 
                1 as UUID,
                ST.Style as name,
                null as sku,
                null as cat,
                null as cid,
                null as sub,
                null as sid,
                null as sup,
                ST.brand as brand,
                STX.TAX_RATE_1 as tax,
                'true' as quick,
                null as tile,
                 1 as UUID1,
                'true' as loy,
                'true' as cloy,
                1 as lp,
                null as opt1,
                null as opt2,
                null as tp,
                'true' as sn,
                null as d,
                null as s
            FROM TB_STYLES ST 
            LEFT JOIN TB_SKUS SK ON (ST.STYLE_ID = SK.STYLE_ID) 
            LEFT JOIN TB_SKU_BUCKETS SB ON (SK.SKU_ID = SB.SKU_ID AND SB.STORE_ID = :storeId) 
            LEFT JOIN TB_ATTR1_ENTRIES C ON (SK.ATTR1_ENTRY_ID = C.ATTR1_ENTRY_ID) 
            LEFT JOIN TB_ATTR2_ENTRIES W ON (SK.ATTR2_ENTRY_ID = W.ATTR2_ENTRY_ID) 
            LEFT JOIN TB_SIZE_ENTRIES S ON (SK.SCALE_ENTRY_ID = S.SCALE_ENTRY_ID) 
            LEFT JOIN TB_STORE_TAX STX ON (SB.STORE_ID = STX.STORE_ID AND STX.DEPT = 'ALL') 
            WHERE SB.STORE_ID = :storeId 
            AND (:lastUpdated IS NULL OR SB.DLU > :lastUpdated)
            ORDER BY ST.STYLE_ID
            """,
            countQuery = """
                    SELECT COUNT(DISTINCT ST.STYLE_ID)
                    FROM TB_STYLES ST 
                    LEFT JOIN TB_SKUS SK ON (ST.STYLE_ID = SK.STYLE_ID) 
                    LEFT JOIN TB_SKU_BUCKETS SB ON (SK.SKU_ID = SB.SKU_ID AND SB.STORE_ID = :storeId) 
                    WHERE SB.STORE_ID = :storeId 
                    AND (:lastUpdated IS NULL OR SB.DLU > :lastUpdated)
                    """,
            nativeQuery = true)
    Page<Object[]> findProductsByStoreAndLastUpdated(
            @Param("storeId") Integer storeId,
            @Param("lastUpdated") LocalDateTime lastUpdated,
            Pageable pageable
    );

    @Query("SELECT COUNT(DISTINCT s) FROM Style s JOIN s.skus sk JOIN sk.skuBuckets sb "
            + "WHERE sb.storeId = :storeId AND (:lastUpdated IS NULL OR sb.dlu > :lastUpdated)")
    long countByStoreAndLastUpdated(
            @Param("storeId") Integer storeId,
            @Param("lastUpdated") LocalDateTime lastUpdated
    );
}

