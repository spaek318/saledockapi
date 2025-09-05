package com.celerant.celerantapi.module.customer.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CUST_ADDRESS")
public class CustomerAddress {
    @EmbeddedId
    private CustomerAddressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerId")
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "BILLING", length = 1,columnDefinition = "char")
    private String billing;

    @UpdateTimestamp
    @Column(name = "DLU")
    private LocalDateTime dlu;

    // Constructors, getters, setters...
}
