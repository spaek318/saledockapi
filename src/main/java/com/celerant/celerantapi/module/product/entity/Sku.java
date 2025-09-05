package com.celerant.celerantapi.module.product.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_SKUS")
public class Sku {

    @Id
    @Column(name = "SKU_ID")
    private Integer skuId;

    @Column(name = "STYLE_ID")
    private Integer styleId;

    @Column(name = "ATTR1_ENTRY_ID")
    private Integer attr1EntryId;

    @Column(name = "ATTR2_ENTRY_ID")
    private Integer attr2EntryId;

    @Column(name = "SCALE_ENTRY_ID")
    private Integer scaleEntryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STYLE_ID", insertable = false, updatable = false)
    private Style style;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTR1_ENTRY_ID", insertable = false, updatable = false)
    private Attr1Entry attr1Entry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTR2_ENTRY_ID", insertable = false, updatable = false)
    private Attr2Entry attr2Entry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCALE_ENTRY_ID", insertable = false, updatable = false)
    private SizeEntry sizeEntry;


    @OneToMany(mappedBy = "sku", fetch = FetchType.LAZY)
    private List<SkuBucket> skuBuckets;

    // Constructors, getters, and setters
    public Sku() {
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getAttr1EntryId() {
        return attr1EntryId;
    }

    public void setAttr1EntryId(Integer attr1EntryId) {
        this.attr1EntryId = attr1EntryId;
    }

    public Integer getAttr2EntryId() {
        return attr2EntryId;
    }

    public void setAttr2EntryId(Integer attr2EntryId) {
        this.attr2EntryId =
                attr2EntryId;
    }

    public Integer getScaleEntryId() {
        return scaleEntryId;
    }

    public void setScaleEntryId(Integer scaleEntryId) {
        this.scaleEntryId =
                scaleEntryId;
    }


    // Navigation properties
    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Attr1Entry getAttr1Entry() {
        return attr1Entry;
    }

    public void setAttr1Entry(Attr1Entry attr1Entry) {
        this.attr1Entry = attr1Entry;
    }

    public Attr2Entry getAttr2Entry() {
        return attr2Entry;
    }

    public void setAttr2Entry(Attr2Entry attr2Entry) {
        this.attr2Entry = attr2Entry;
    }

    public SizeEntry getSizeEntry() {
        return sizeEntry;
    }

    public void setSizeEntry(SizeEntry sizeEntry) {
        this.sizeEntry = sizeEntry;
    }

    public List<SkuBucket> getSkuBuckets() {
        return skuBuckets;
    }

    public void setSkuBuckets(List<SkuBucket> skuBuckets) {
        this.skuBuckets = skuBuckets;
    }
}
