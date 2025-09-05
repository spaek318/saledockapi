package com.celerant.celerantapi.module.customer.service;


import com.celerant.celerantapi.module.customer.dto.CustomerResponse;
import com.celerant.celerantapi.module.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    //@Cacheable(value = "customers", key = "#customerId"), unless = "#result.isEmpty()")
    @Cacheable(value = "customers", key="#p0", condition="#p0!=null")
    public Optional<CustomerResponse> getCustomerById(Integer customerId) {
        logger.debug("Fetching customer with ID: {}", customerId);

        if (customerId == null || customerId <= 0) {
            logger.warn("Invalid customer ID provided: {}", customerId);
            return Optional.empty();
        }

        try {
            Optional<CustomerResponse> customerResponse = customerRepository.findCustomerWithDetailsById(customerId);

            if (customerResponse.isPresent()) {
                logger.info("Customer found with ID: {}", customerId);
            } else {
                logger.info("No customer found with ID: {}", customerId);
            }

            return customerResponse;
        } catch (Exception e) {
            logger.error("Error fetching customer with ID: {}", customerId, e);
            throw new RuntimeException("Error retrieving customer data", e);
        }
    }

    @Override
    public boolean existsById(Integer customerId) {
        if (customerId == null || customerId <= 0) {
            return false;
        }

        return customerRepository.existsByCustomerId(customerId);
    }
}
