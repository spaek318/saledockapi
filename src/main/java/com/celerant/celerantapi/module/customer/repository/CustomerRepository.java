package com.celerant.celerantapi.module.customer.repository;

import com.celerant.celerantapi.module.customer.dto.CustomerResponse;


import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository {
    //extends JpaRepository<Customer, Integer> {
    Optional<CustomerResponse> findCustomerWithDetailsById(Integer customerId);

    //    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.customerAddresses ca LEFT JOIN FETCH ca.address LEFT JOIN FETCH c.houseAccount WHERE c.customerId = :customerId")
//    Optional<Customer> findByIdWithDetails(@Param("customerId") Integer customerId);
//
//    @Query("SELECT c FROM Customer c WHERE c.email1 = :email")
//    Optional<Customer> findByEmail(@Param("email") String email);
//
    boolean existsByCustomerId(Integer customerId);
}
