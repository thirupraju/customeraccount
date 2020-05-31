package com.ms.customer.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.customer.account.entity.CustomerAccount;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, String> {
	
	CustomerAccount getCustomerAccountByAccountName(String accountName);

}
