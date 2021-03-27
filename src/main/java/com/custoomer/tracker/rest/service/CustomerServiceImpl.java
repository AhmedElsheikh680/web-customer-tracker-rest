package com.custoomer.tracker.rest.service;

import com.custoomer.tracker.rest.dao.CustomerDao;

import com.custoomer.tracker.rest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        customerDao.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Integer id) {

            return customerDao.findById(id).orElse(null);


    }

    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public void delete(Customer object) {

    }

    @Override
    public void deleteById(Integer id) {
        customerDao.deleteById(id);
    }
}
