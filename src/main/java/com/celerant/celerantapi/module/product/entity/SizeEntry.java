package com.celerant.celerantapi.module.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "TB_SIZE_ENTRIES")
public class SizeEntry {


    @Id
    @Column(name = "SCALE_ENTRY_ID")
    private Integer id;

    @Column(name = "SIZE_ORDER")
    private Integer attr1;
}
