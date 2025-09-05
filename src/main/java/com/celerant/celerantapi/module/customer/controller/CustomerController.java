package com.celerant.celerantapi.module.customer.controller;


import com.celerant.celerantapi.common.exception.CustomerNotFoundException;
import com.celerant.celerantapi.module.customer.dto.CustomerResponse;
import com.celerant.celerantapi.module.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Validated
@Tag(name = "Customer", description = "Customer management operations")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    @Operation(summary = "Get customer by ID", description =
            "Retrieves customer details including addresses and account information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "400", description = "Invalid customer ID")
    })
    public ResponseEntity<CustomerResponse> getCustomerById(
            @Parameter(description = "Customer ID", required = true)
            @PathVariable("customerId")
            @NotNull(message = "Customer ID cannot be null")
            @Min(value = 1, message = "Customer ID must be greater than 0")
            Integer customerId) {

        logger.info("Received request to get customer with ID: {}", customerId);

        Optional<CustomerResponse> customerResponse = customerService.getCustomerById(customerId);

        if (customerResponse.isPresent()) {
            logger.info("Successfully retrieved customer with ID: {}", customerId);
            return ResponseEntity.ok(customerResponse.get());
        } else {
            logger.warn("Customer not found with ID: {}", customerId);
            throw new CustomerNotFoundException("Customer not found with ID: " +
                    customerId);
        }
    }

    @GetMapping("/{customerId}/exists")
    @Operation(summary = "Check if customer exists", description = "Checks whether a customer exists by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check completed"),
            @ApiResponse(responseCode = "400", description = "Invalid customer ID")
    })
    public ResponseEntity<Boolean> checkCustomerExists(
            @Parameter(description = "Customer ID", required = true)
            @PathVariable("customerId")
            @NotNull(message = "Customer ID cannot be null")
            @Min(value = 1, message = "Customer ID must be greater than 0")
            Integer customerId) {

        logger.debug("Checking if customer exists with ID: {}", customerId);

        boolean exists = customerService.existsById(customerId);

        logger.debug("Customer with ID {} exists: {}", customerId, exists);

        return ResponseEntity.ok(exists);
    }
}
