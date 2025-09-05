package com.celerant.celerantapi.module.customer.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_CUSTOMERS")
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @Column(name = "STORE_ID")
    private Integer storeId;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "EMAIL1", length = 60)
    private String email1;

    @Column(name = "COMPANY", length = 50)
    private String company;

    @Column(name = "BIRTH_MONTH")
    private Integer birthMonth;

    @Column(name = "BIRTH_DAY")
    private Integer birthDay;

    @Column(name = "BIRTH_YEAR")
    private Integer birthYear;

    @Column(name = "CAN_EMAIL", length = 1, columnDefinition = "char")
    private String canEmail;

    @Column(name = "FREE_PURCHASE", precision = 15, scale = 2)
    private BigDecimal freePurchase;

    @CreationTimestamp
    @Column(name = "DATE_ENTERED")
    private LocalDateTime dateEntered;

    @UpdateTimestamp
    @Column(name = "DLU")
    private LocalDateTime dlu;

    //    @Column(name = "sdkey")
//    private UUID sdkey;
    // Relationships
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerAddress> customerAddresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerNote> customerNotes;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    private HouseAccount houseAccount;

    // Constructors
    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    // Getters and Setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getCanEmail() {
        return canEmail;
    }

    public void setCanEmail(String canEmail) {
        this.canEmail = canEmail;
    }

    public BigDecimal getFreePurchase() {
        return freePurchase;
    }

    public void setFreePurchase(BigDecimal freePurchase) {
        this.freePurchase = freePurchase;
    }

    public LocalDateTime getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(LocalDateTime dateEntered) {
        this.dateEntered = dateEntered;
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

    public List<CustomerNote> getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(List<CustomerNote> customerNotes) {
        this.customerNotes = customerNotes;
    }

    public HouseAccount getHouseAccount() {
        return houseAccount;
    }

    public void setHouseAccount(HouseAccount houseAccount) {
        this.houseAccount = houseAccount;
    }
}
