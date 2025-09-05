package com.celerant.celerantapi.module.customer.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CUSTOMER_NOTE")
public class CustomerNote {
    @Id
    @Column(name = "CUSTOMER_NOTE_ID")
    private Integer customerNoteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "NOTE_DETAIL", length = 2000)
    private String noteDetail;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    // Other fields, constructors, getters, setters...
}
