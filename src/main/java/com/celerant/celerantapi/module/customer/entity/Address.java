package com.celerant.celerantapi.module.customer.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    private Integer addressId;

    @Column(name = "ADDRESS1", length = 50)
    private String address1;

    @Column(name = "ADDRESS2", length = 50)
    private String address2;

    @Column(name = "ADDRESS3", length = 50)
    private String address3;

    @Column(name = "CITY", length = 40)
    private String city;

    @Column(name = "STATE", length = 5, columnDefinition = "char")
    private String state;

    @Column(name = "ZIP", length = 10)
    private String zip;

    @Column(name = "COUNTRY", length = 20)
    private String country;

    @Column(name = "PHONE1", length = 20)
    private String phone1;

    @Column(name = "PHONE2", length = 20)
    private String phone2;

    @Column(name = "EMAIL1", length = 60)
    private String email1;

    @UpdateTimestamp
    @Column(name = "DLU")
    private LocalDateTime dlu;

//    @Column(name = "sdkey")
//    private UUID sdkey;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<CustomerAddress> customerAddresses;

    // Constructors, getters, and setters
    public Address() {
    }

    // Getters and Setters (similar pattern as Customer)
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public LocalDateTime getDlu() {
        return dlu;
    }

    public void setDlu(LocalDateTime dlu) {
        this.dlu = dlu;
    }

//    public UUID getSdkey() { return sdkey; }
//    public void setSdkey(UUID sdkey) { this.sdkey = sdkey; }

    public List<CustomerAddress> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }
}
