package com.celerant.celerantapi.module.product.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_STYLES")
public class Style {

    @Id
    @Column(name = "STYLE_ID")
    private Integer styleId;

    @Column(name = "STYLE", length = 40)
    private String style;

    @Column(name = "BRAND", length = 40)
    private String brand;

    @Column(name = "DESCRIPTION", length = 80)
    private String description;


    @OneToMany(mappedBy = "style", fetch = FetchType.LAZY)
    private List<Sku> skus;

    // Constructors
    public Style() {
    }

    // Getters and setters
    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}

