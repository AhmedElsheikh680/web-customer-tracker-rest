package com.custoomer.tracker.rest.controller;

import com.custoomer.tracker.rest.model.Customer;
import com.custoomer.tracker.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public Set<Customer> getCustomers(){
        return customerService.findAll();
    }
}
