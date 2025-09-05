package com.celerant.celerantapi.module.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_ATTR2_ENTRIES")
public class Attr2Entry {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getAttr1() {
//        return attr1;
//    }
//
//    public void setAttr1(Integer attr1) {
//        this.attr1 = attr1;
//    }

    @Id
    @Column(name = "ATTR2_ID")
    private Integer id;

//    @Column(name = "ATTR2")
//    private Integer attr1;
}
