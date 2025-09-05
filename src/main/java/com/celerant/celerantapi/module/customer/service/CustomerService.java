package com.celerant.celerantapi.module.customer.service;

import com.celerant.celerantapi.module.customer.dto.CustomerResponse;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerResponse> getCustomerById(Integer customerId);

    boolean existsById(Integer customerId);
}
