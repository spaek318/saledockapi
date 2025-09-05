package com.celerant.celerantapi.module.customer.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_HOUSE_ACCOUNT")
public class HouseAccount {
    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "CREDIT_LIMIT", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @Column(name = "ACCNT_OWED", precision = 15, scale = 2)
    private BigDecimal accntOwed;

    @Column(name = "ACCNT_NUM", length = 20)
    private String accntNum;

    // Other fields, constructors, getters, setters...
}
