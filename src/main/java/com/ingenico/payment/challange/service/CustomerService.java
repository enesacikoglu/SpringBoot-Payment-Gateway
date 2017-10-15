package com.ingenico.payment.challange.service;

import java.util.List;

import com.ingenico.payment.challange.entity.Customer;

public interface CustomerService {

	List<Customer> findAllCustomers();

	Customer findCustomerById(String id);

}
