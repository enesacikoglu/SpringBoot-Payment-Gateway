package com.ingenico.payment.challange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingenico.payment.challange.entity.CustomerAccount;
import com.ingenico.payment.challange.model.MoneyTransferModel;
import com.ingenico.payment.challange.service.CustomerAccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/payment/transfer")
public class CustomerAccountRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerAccountService customerAccountService;

	@ApiOperation(value = "Transfer money with given Accounts and amount", notes = "Return Customer Account after money transfer")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"),
			@ApiResponse(code = 200, message = "MoneyTransferModel"),
			@ApiResponse(code = 500, message = "Error occurred while transfer money one account to another.") })
	@RequestMapping(value = "/sendMoney", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CustomerAccount> transferMoney(@RequestParam("fromAccount") String fromAccount,
			@RequestParam("toAccount") String toAccount, @RequestParam("amount") double amount) throws Exception {

		this.logger.info("CustomerAccountRestController - transferMoney() method is called.");

		return new ResponseEntity<CustomerAccount>(
				this.customerAccountService.transfer(new MoneyTransferModel(fromAccount, amount, toAccount)),
				HttpStatus.OK);

	}

	@ApiOperation(value = "Add money with given Account", notes = "Return Customer Account after add money")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"),
			@ApiResponse(code = 200, message = "CustomerAccount"),
			@ApiResponse(code = 500, message = "Error occurred while saving money to given account.") })
	@RequestMapping(value = "/addMoney", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CustomerAccount> addMoney(@RequestParam("accountId") String accountId,
			@RequestParam("amount") double amount) throws Exception {

		this.logger.info("CustomerAccountRestController - addMoney() method is called.");

		return new ResponseEntity<CustomerAccount>(this.customerAccountService.addMoney(amount, accountId),
				HttpStatus.OK);

	}

	@ApiOperation(value = "Withdraw money with given Account", notes = "Return Customer Account after money withdraw")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"),
			@ApiResponse(code = 200, message = "CustomerAccount"),
			@ApiResponse(code = 500, message = "Error occurred while withdraw money to given account.") })
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CustomerAccount> withdraw(@RequestParam("accountId") String accountId,
			@RequestParam("amount") double amount) throws Exception {

		this.logger.info("CustomerAccountRestController - withdraw() method is called.");

		return new ResponseEntity<CustomerAccount>(this.customerAccountService.withdraw(amount, accountId),
				HttpStatus.OK);

	}

	@ApiOperation(value = "Check Account balance with given AccountId", notes = "Return Customer Account after check balance")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"),
			@ApiResponse(code = 200, message = "CustomerAccount"),
			@ApiResponse(code = 500, message = "Error occurred while checking balance for given account.") })
	@RequestMapping(value = "/checkBalance", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CustomerAccount> checkBalance(@RequestParam("accountId") String accountId) throws Exception {

		this.logger.info("CustomerAccountRestController - checkBalance() method is called.");

		return new ResponseEntity<CustomerAccount>(this.customerAccountService.checkBalance(accountId), HttpStatus.OK);

	}

}
