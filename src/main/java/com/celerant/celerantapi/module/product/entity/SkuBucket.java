package com.celerant.celerantapi.module.product.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SKU_BUCKETS")
public class SkuBucket {

    @Id
    @Column(name = "SKU_BUCKET_ID")
    private Integer skuBucketId;

    @Column(name = "SKU_ID")
    private Integer skuId;

    @Column(name = "STORE_ID")
    private Integer storeId;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "AVG_COST")
    private Double avgCost;

    @Column(name = "QOH")
    private Double qoh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKU_ID", insertable = false, updatable = false)
    private Sku sku;


    @UpdateTimestamp
    @Column(name = "DLU")
    private LocalDateTime dlu;

    // Constructors, getters, and setters
    public SkuBucket() {
    }

    public Integer getSkuBucketId() {
        return skuBucketId;
    }

    public void setSkuBucketId(Integer skuBucketId) {
        this.skuBucketId = skuBucketId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(Double avgCost) {
        this.avgCost = avgCost;
    }

    public Double getQoh() {
        return qoh;
    }

    public void setQoh(Double qoh) {
        this.qoh = qoh;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public LocalDateTime getDlu() {
        return dlu;
    }

    public void setDlu(LocalDateTime dlu) {
        this.dlu = dlu;
    }

}
