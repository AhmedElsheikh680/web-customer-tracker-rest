package com.custoomer.tracker.rest.controller;

import com.custoomer.tracker.rest.exception.CustomerNotFoundException;
import com.custoomer.tracker.rest.model.Customer;
import com.custoomer.tracker.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
       List<Customer> customers =  customerService.findAll();
       if(customers !=null){
           return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
       }else{
           return new ResponseEntity<List<Customer>>(customers, HttpStatus.NOT_FOUND);
       }
    }

//    @GetMapping("/customers/{id}")
//    public ResponseEntity<Customer> findById(@PathVariable int id){
//        Customer customer = customerService.findById(id);
//        if( customer !=null){
//            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
//        }
//
//
//    }

    @GetMapping("/customers/{id}")
    public Customer  findById(@PathVariable int id){
        Customer customer = customerService.findById(id);
        if(customer == null){
            throw new CustomerNotFoundException("Customer Id Not Found  - "+id);
        }
        return customer;

    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id){
        Customer tempCustomer = customerService.findById(id);
        if(tempCustomer == null){
            throw new CustomerNotFoundException("Customer Id Not Found  - "+id);
        }
        customerService.deleteById(id);
        return "Deleted Customer Id - "+id;
    }









}
