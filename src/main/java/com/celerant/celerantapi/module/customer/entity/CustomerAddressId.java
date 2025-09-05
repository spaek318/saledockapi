package com.celerant.celerantapi.module.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CustomerAddressId implements Serializable {
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @Column(name = "ADDRESS_ID")
    private Integer addressId;

    // equals, hashCode, constructors, getters, setters...
}
