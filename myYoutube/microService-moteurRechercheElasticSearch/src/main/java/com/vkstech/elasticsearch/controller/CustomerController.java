package com.vkstech.elasticsearch.controller;

import com.vkstech.elasticsearch.entity.Customer;
import com.vkstech.elasticsearch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers) {
        customerRepository.saveAll(customers);
        return customers.size();
    }

    @GetMapping("findAll")
    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("findByFirstName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable String firstName) {
        return customerRepository.findByFirstName(firstName);
    }


}
