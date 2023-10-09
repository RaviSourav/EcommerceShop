package com.rs.ecommerce.shop.controller;

import com.rs.ecommerce.shop.model.Customer;
import com.rs.ecommerce.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(("/customers"))
    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }

    @GetMapping(("/customers/{cusId}"))
    public Optional<Customer> getCustomersById(@PathVariable("cusId") int id)
    {
        return customerRepository.findById(id);
    }

    @PostMapping("/customers")
    public Customer addCustomersById(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
        return customer;
    }
}
