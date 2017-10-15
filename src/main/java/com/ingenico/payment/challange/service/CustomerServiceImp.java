package com.ingenico.payment.challange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenico.payment.challange.entity.Customer;
import com.ingenico.payment.challange.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(String id) {
		return customerRepository.findByCustomerId(id);
	}

}
