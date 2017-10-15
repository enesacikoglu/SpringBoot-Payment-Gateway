package com.ingenico.payment.challange.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ingenico.payment.challange.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByCustomerId(String customerId);

	List<Customer> findByCustomerNameAndCustomerSurname(String customerName, String customerSurname);

}
