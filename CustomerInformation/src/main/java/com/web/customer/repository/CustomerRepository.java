package com.web.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
