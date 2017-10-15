package com.ingenico.payment.challange.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ingenico.payment.challange.entity.CustomerAccount;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {

	CustomerAccount findByAccountId(String accountId);

	List<CustomerAccount> findByCustomerId(String customerId);

}
