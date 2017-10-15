package com.ingenico.payment.challange.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ingenico.payment.challange.entity.Customer;
import com.ingenico.payment.challange.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Gets all active customers", notes = "Return All Customers")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"),
			@ApiResponse(code = 200, message = "List<Customer>"),
			@ApiResponse(code = 500, message = "Error occurred while getting customers.") })
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> findAllCustomers() {

		this.logger.info("CustomerRestController - findAllCustomers() method is called.");

		return new ResponseEntity<List<Customer>>(this.customerService.findAllCustomers(), HttpStatus.OK);

	}

	@ApiOperation(value = "Get Customer with given customerID", notes = "Return customer")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"),
			@ApiResponse(code = 200, message = "Customer"),
			@ApiResponse(code = 500, message = "Error occurred while getting customer") })
	@RequestMapping(value = "{customerId}", method = RequestMethod.GET)
	public ResponseEntity<Customer> findCustomerByCustomerId(@PathVariable String customerId) {

		this.logger.info("CustomerRestController - findAllCustomers() method is called.");

		return new ResponseEntity<Customer>(this.customerService.findCustomerById(customerId), HttpStatus.OK);

	}

}
