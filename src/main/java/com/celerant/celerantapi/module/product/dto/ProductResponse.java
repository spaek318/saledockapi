package com.celerant.celerantapi.module.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {

    @JsonProperty("pk")
    private UUID pk;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("cat")
    private String cat;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("sub")
    private String sub;

    @JsonProperty("sid")
    private String sid;

    @JsonProperty("sup")
    private String sup;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("tax")
    private BigDecimal tax;

    @JsonProperty("quick")
    private String quick;

    @JsonProperty("tile")
    private String tile;

    @JsonProperty("ver")
    private UUID ver;

    @JsonProperty("loy")
    private String loy;

    @JsonProperty("cloy")
    private String cloy;

    @JsonProperty("lp")
    private Integer lp;

    @JsonProperty("opt1")
    private String opt1;

    @JsonProperty("opt2")
    private String opt2;

    @JsonProperty("tp")
    private String tp;

    @JsonProperty("sn")
    private String sn;

    @JsonProperty("d")
    private String d;

    @JsonProperty("s")
    private String s;

    // Constructors
    public ProductResponse() {
    }

    // Getters and setters
    public UUID getPk() {
        return pk;
    }

    public void setPk(UUID pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getQuick() {
        return quick;
    }

    public void setQuick(String quick) {
        this.quick = quick;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public UUID getVer() {
        return ver;
    }

    public void setVer(UUID ver) {
        this.ver = ver;
    }

    public String getLoy() {
        return loy;
    }

    public void setLoy(String loy) {
        this.loy = loy;
    }

    public String getCloy() {
        return cloy;
    }

    public void setCloy(String cloy) {
        this.cloy = cloy;
    }

    public Integer getLp() {
        return lp;
    }

    public void setLp(Integer lp) {
        this.lp = lp;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}

