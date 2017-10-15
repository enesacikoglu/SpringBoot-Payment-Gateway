package com.ingenico.payment.challange.service;

import java.util.List;

import com.ingenico.payment.challange.entity.CustomerAccount;
import com.ingenico.payment.challange.model.MoneyTransferModel;

public interface CustomerAccountService {

	public CustomerAccount addMoney(double amount, String accountId) throws Exception;

	public CustomerAccount withdraw(double amount, String accountId) throws Exception;

	public CustomerAccount transfer(MoneyTransferModel transferModel) throws Exception;

	public List<CustomerAccount> getCustomerAccounts(String customerId) throws Exception;

	public CustomerAccount checkBalance(String accountId) throws Exception;

}
