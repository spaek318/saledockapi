package com.celerant.celerantapi.module.product.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_STORE_TAX")
@IdClass(StoreTaxId.class)
public class StoreTax {

    @Id
    @Column(name = "STORE_ID")
    private Integer storeId;

    @Id
    @Column(name = "DEPT", length = 40)
    private String dept;

    @Column(name = "TAX_RATE_1", precision = 15, scale = 4)
    private BigDecimal taxRate1;

    // Constructors, getters, and setters
    public StoreTax() {
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public BigDecimal getTaxRate1() {
        return taxRate1;
    }

    public void setTaxRate1(BigDecimal taxRate1) {
        this.taxRate1 = taxRate1;
    }
}

// Composite key class
class StoreTaxId implements java.io.Serializable {
    private Integer storeId;
    private String dept;

    // Default constructor, equals, hashCode methods
    public StoreTaxId() {
    }

    public StoreTaxId(Integer storeId, String dept) {
        this.storeId = storeId;
        this.dept = dept;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreTaxId)) return false;
        StoreTaxId that = (StoreTaxId) o;
        return storeId.equals(that.storeId) && dept.equals(that.dept);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(storeId, dept);
    }
}

