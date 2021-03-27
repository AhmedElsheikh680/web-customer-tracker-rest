package com.custoomer.tracker.rest.dao;

import com.custoomer.tracker.rest.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
