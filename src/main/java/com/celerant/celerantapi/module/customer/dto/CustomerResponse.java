package com.celerant.celerantapi.module.customer.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
//TODO: is it sdkey?
//    @JsonProperty("key")
//    private String key;

    @JsonProperty("user")
    private Integer user;

    @JsonProperty("store")
    private Integer store;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("note")
    private String note;

    @JsonProperty("marketingOptIn")
    private String marketingOptIn;

    @JsonProperty("deleted")
    private String deleted;

    @JsonProperty("versionKey")
    private String versionKey;

    @JsonProperty("createDate")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime createDate;

    @JsonProperty("updateDate")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime updateDate;

    @JsonProperty("salesValue")
    private BigDecimal salesValue;

    @JsonProperty("loyaltyEnabled")
    private String loyaltyEnabled;

    @JsonProperty("loyaltyPoints")
    private BigDecimal loyaltyPoints;

    @JsonProperty("group")
    private String group;

    @JsonProperty("GroupName")
    private String groupName;

    @JsonProperty("CompanyName")
    private String companyName;

    @JsonProperty("website")
    private String website;

    @JsonProperty("dateofBirth")
    private String dateOfBirth;

    @JsonProperty("hubSpotId")
    private String hubSpotId;

    @JsonProperty("creditbalance")
    private BigDecimal creditBalance;

    @JsonProperty("onAccountLimit")
    private BigDecimal onAccountLimit;

    @JsonProperty("onAccountBalance")
    private BigDecimal onAccountBalance;

    @JsonProperty("companyRegNo")
    private String companyRegNo;

    @JsonProperty("companyVatNo")
    private String companyVatNo;

    @JsonProperty("ageVerified")
    private String ageVerified;

    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("eoriNumber")
    private String eoriNumber;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("invoiceCountryCode")
    private String invoiceCountryCode;

    @JsonProperty("isInternational")
    private String isInternational;

    @JsonProperty("priceList")
    private String priceList;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("address")
    private AddressResponse address;

    // Constructors
    public CustomerResponse() {
    }

    // Getters and Setters
//    public String getKey() { return key; }
//    public void setKey(String key) { this.key = key; }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMarketingOptIn() {
        return marketingOptIn;
    }

    public void setMarketingOptIn(String marketingOptIn) {
        this.marketingOptIn = marketingOptIn;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

//    public String getVersionKey() { return versionKey; }
//    public void setVersionKey(String versionKey) { this.versionKey = versionKey; }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(BigDecimal salesValue) {
        this.salesValue = salesValue;
    }

    public String getLoyaltyEnabled() {
        return loyaltyEnabled;
    }

    public void setLoyaltyEnabled(String loyaltyEnabled) {
        this.loyaltyEnabled = loyaltyEnabled;
    }

    public BigDecimal getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(BigDecimal loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHubSpotId() {
        return hubSpotId;
    }

    public void setHubSpotId(String hubSpotId) {
        this.hubSpotId = hubSpotId;
    }

    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(BigDecimal creditBalance) {
        this.creditBalance = creditBalance;
    }

    public BigDecimal getOnAccountLimit() {
        return onAccountLimit;
    }

    public void setOnAccountLimit(BigDecimal onAccountLimit) {
        this.onAccountLimit = onAccountLimit;
    }

    public BigDecimal getOnAccountBalance() {
        return onAccountBalance;
    }

    public void setOnAccountBalance(BigDecimal onAccountBalance) {
        this.onAccountBalance = onAccountBalance;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getCompanyVatNo() {
        return companyVatNo;
    }

    public void setCompanyVatNo(String companyVatNo) {
        this.companyVatNo = companyVatNo;
    }

    public String getAgeVerified() {
        return ageVerified;
    }

    public void setAgeVerified(String ageVerified) {
        this.ageVerified = ageVerified;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEoriNumber() {
        return eoriNumber;
    }

    public void setEoriNumber(String eoriNumber) {
        this.eoriNumber = eoriNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInvoiceCountryCode() {
        return invoiceCountryCode;
    }

    public void setInvoiceCountryCode(String invoiceCountryCode) {
        this.invoiceCountryCode = invoiceCountryCode;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }
}

