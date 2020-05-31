package com.ms.customer.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ms.customer.account.entity.CustomerAccount;
import com.ms.customer.account.repository.CustomerAccountRepository;

@Service
public class CustomerAccountService {
	@Autowired
	private CustomerAccountRepository repository;

	@Value("${welcome.message}")
	private String welcomeMsg;
	
	public CustomerAccount saveCustomerAccount(CustomerAccount customerAccount) {
		return repository.save(customerAccount);
	}
	
	public List<CustomerAccount> saveCustomerAccounts(List<CustomerAccount> customerAccounts) {
		return repository.saveAll(customerAccounts);
	}
	
	public List<CustomerAccount> getCustomerAccounts() {
		System.out.println(welcomeMsg);
		return repository.findAll();
	}
	
	public CustomerAccount getCustomerAccountById(String customerId) {
		return repository.findById(customerId).orElse(null);
	}
	
	public CustomerAccount getCustomerAccountByName(String accountName) {
		return repository.getCustomerAccountByAccountName(accountName);
	}
	
	public String deleteCustomerAccount(String customerId) {
		repository.deleteById(customerId);
		return "Customer Account Deleted || " + customerId;
	}
	
	public CustomerAccount updateCustomerAccount(CustomerAccount customerAccount) {
/*
		System.out.println(customerAccount.getAccountName());
		System.out.println(customerAccount.getAccountType());
		System.out.println(customerAccount.getCustomerId());
*/
		CustomerAccount existingCustomerAccount = repository.findById(customerAccount.getCustomerId()).orElse(null);
		
		existingCustomerAccount.setAccountName(customerAccount.getAccountName());
		existingCustomerAccount.setAccountType(customerAccount.getAccountType());
		repository.save(existingCustomerAccount);
		return existingCustomerAccount;
	}
}
