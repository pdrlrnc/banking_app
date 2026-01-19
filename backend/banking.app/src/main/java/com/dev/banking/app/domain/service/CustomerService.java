package com.dev.banking.app.domain.service;

import com.dev.banking.app.domain.model.Customer;
import com.dev.banking.app.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

    public ResponseEntity<Customer> getById(Long id)
    {
        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
