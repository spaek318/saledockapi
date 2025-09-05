package com.celerant.celerantapi.module.customer.repository;


import com.celerant.celerantapi.module.customer.dto.AddressResponse;
import com.celerant.celerantapi.module.customer.dto.CustomerResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<CustomerResponse> findCustomerWithDetailsById(Integer customerId) {
        String sql = """
                SELECT 
                    cu.customer_id as userId,
                    cu.store_id as store,
                    cu.first_name as firstName,
                    cu.last_name as lastName,
                    ad.email1 as emailAddress,
                    ad.phone1 as phone,
                    ad.phone2 as mobile,
                    ISNULL(cn.note_detail,'') as note,
                    CASE WHEN cu.can_email='Y' THEN 'true' ELSE 'false' END as marketingOptIn,
                    'false' as deleted,
                    cu.date_entered as createDate,
                    cu.dlu as updateDate,
                    null as salesValue,
                    'true' as loyaltyEnabled,
                    cu.free_purchase as loyaltyPoints,
                    null as groupId,
                    null as groupName,
                    cu.company as companyName,
                    null as website,
                    CASE 
                        WHEN cu.birth_year IS NOT NULL AND cu.birth_month IS NOT NULL AND cu.birth_day IS NOT NULL
                        THEN CAST(cu.birth_year as varchar(4)) + '/' + 
                             RIGHT('0' + CAST(cu.birth_month as varchar(2)), 2) + '/' + 
                             RIGHT('0' + CAST(cu.birth_day as varchar(2)), 2)
                        ELSE null
                    END as dateOfBirth,
                    null as hubSpotId,
                    null as creditBalance,
                    ha.credit_limit as onAccountLimit,
                    ha.accnt_owed as onAccountBalance,
                    null as companyRegNo,
                    null as companyVatNo,
                    'true' as ageVerified,
                    null as jobTitle,
                    null as eoriNumber,
                    ha.accnt_num as accountNumber,
                    'USA' as invoiceCountryCode,
                    'false' as isInternational,
                    null as priceList,
                    null as displayName,
                    cu.customer_ID as addressUser,
                    1 as addressType,
                    ad.address1 as addressLine1,
                    ad.address2 as addressLine2,
                    ad.city as town,
                    ad.zip as postcode,
                    ad.country as country,
                    cu.first_name as addressFirstName,
                    cu.last_name as addressLastName,
                    cu.email1 as addressEmailAddress,
                    ad.phone1 as addressPhone,
                    null as lat,
                    null as lng,
                    'true' as isDefault,
                    'true' as sameAs,
                    null as countryId,
                    ad.country as countryName,
                    cu.date_entered as addressCreateDate,
                    ad.dlu as addressUpdateDate,
                    'true' as isSynced,
                    'true' as isStockist,
                    null as contactName,
                    null as addressTypeName,
                    null as display
                FROM TB_CUSTOMERS cu 
                LEFT JOIN TB_CUST_ADDRESS cuad ON (cu.customer_id = cuad.customer_id) 
                LEFT JOIN TB_ADDRESS ad ON (cuad.address_id = ad.address_id) 
                LEFT JOIN TB_CUSTOMER_NOTE cn ON (cu.customer_id = cn.customer_id) 
                LEFT JOIN TB_HOUSE_ACCOUNT ha ON (cu.customer_id = ha.customer_id)
                WHERE cu.customer_id = :customerId
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("customerId", customerId);

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();


        if (results.isEmpty()) {
            return Optional.empty();
        }
        results.get(0);

        return Optional.of(mapToCustomerResponse(results.get(0)));
    }

    @Override
    public boolean existsByCustomerId(Integer customerId) {
        return false;
    }

    private CustomerResponse mapToCustomerResponse(Object[] row) {
        CustomerResponse response = new CustomerResponse();

        int i = 0;
        //response.setKey((String) row[i++]);
        response.setUser((Integer) row[i++]);
        response.setStore((Integer) row[i++]);
        response.setFirstName((String) row[i++]);
        response.setLastName((String) row[i++]);
        response.setEmailAddress((String) row[i++]);
        response.setPhone((String) row[i++]);
        response.setMobile((String) row[i++]);
        response.setNote((String) row[i++]);
        response.setMarketingOptIn((String) row[i++]);
        response.setDeleted((String) row[i++]);
        // response.setVersionKey((String) row[i++]);
        response.setCreateDate(toLocalDateTime((Timestamp) row[i++]));
        response.setUpdateDate(toLocalDateTime((Timestamp) row[i++]));
        response.setSalesValue((BigDecimal) row[i++]);
        response.setLoyaltyEnabled((String) row[i++]);
        response.setLoyaltyPoints((BigDecimal) row[i++]);
        response.setGroup((String) row[i++]);
        response.setGroupName((String) row[i++]);
        response.setCompanyName((String) row[i++]);
        response.setWebsite((String) row[i++]);
        response.setDateOfBirth((String) row[i++]);
        response.setHubSpotId((String) row[i++]);
        response.setCreditBalance((BigDecimal) row[i++]);
        response.setOnAccountLimit((BigDecimal) row[i++]);
        response.setOnAccountBalance((BigDecimal) row[i++]);
        response.setCompanyRegNo((String) row[i++]);
        response.setCompanyVatNo((String) row[i++]);
        response.setAgeVerified((String) row[i++]);
        response.setJobTitle((String) row[i++]);
        response.setEoriNumber((String) row[i++]);
        response.setAccountNumber((String) row[i++]);
        response.setInvoiceCountryCode((String) row[i++]);
        response.setIsInternational((String) row[i++]);
        response.setPriceList((String) row[i++]);
        response.setDisplayName((String) row[i++]);

        // Create address response
        AddressResponse address = new AddressResponse();
        //address.setKey((String) row[i++]);  TODO:
        //address.setCustomerKey((String) row[i++]);  TODO
        address.setUser((Integer) row[i++]);
        address.setType((Integer) row[i++]);
        address.setAddressLine1((String) row[i++]);
        address.setAddressLine2((String) row[i++]);
        address.setTown((String) row[i++]);
        address.setPostcode((String) row[i++]);
        address.setCountry((String) row[i++]);
        address.setFirstName((String) row[i++]);
        address.setLastName((String) row[i++]);
        address.setEmailAddress((String) row[i++]);
        address.setPhone((String) row[i++]);
        address.setLat((String) row[i++]);
        address.setLng((String) row[i++]);
        address.setIsDefault((String) row[i++]);
        address.setSameAs((String) row[i++]);
        address.setCountryId((String) row[i++]);
        address.setCountryName((String) row[i++]);
        address.setCreateDate(toLocalDateTime((Timestamp) row[i++]));
        address.setUpdateDate(toLocalDateTime((Timestamp) row[i++]));
        //address.setVersionKey((String) row[i++]);
        address.setIsSynced((String) row[i++]);
        address.setIsStockist((String) row[i++]);
        address.setContactName((String) row[i++]);
        address.setTypeName((String) row[i++]);
        address.setDisplay((String) row[i]);

        response.setAddress(address);

        return response;
    }

    private LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if(timestamp == null) {return null;}
        return timestamp.toLocalDateTime();
    }
}
