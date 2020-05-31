package com.ms.customer.account;

import org.springframework.web.client.RestTemplate;

import com.ms.customer.account.entity.CustomerAccount;

public class TestRestClient {
/*
	private static final String GET_CUSTOMERACCOUNTS_ENDPOINT_URL = "http://localhost:9192/customeraccounts";
	private static final String GET_CUSTOMERACCOUNT_ENDPOINT_URL  = "http://localhost:9192/customeraccount/{id}";
	private static final String CREATE_CUSTOMERACCOUNT_ENDPOINT_URL = "http://localhost:9192/addCustomerAccount";
	private static final String UPDATE_CUSTOMERACCOUNT_ENDPOINT_URL = "http://localhost:9192/update/{id}";
	private static final String DELETE_CUSTOMERACCOUNT_ENDPOINT_URL = "http://localhost:9192/customeraccount/{id}";
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		TestRestClient testRestClient = new TestRestClient();
		
		//1
		testRestClient.createCustomerAccount();
		

	}

	private void createCustomerAccount() {
		CustomerAccount newCustomerAccount = new CustomerAccount("60001","aaa","Savings");
		
		RestTemplate restTemplate = new RestTemplate();
		CustomerAccount result = restTemplate.postForObject(CREATE_CUSTOMERACCOUNT_ENDPOINT_URL, newCustomerAccount, CustomerAccount.class);
		System.out.println(result);
		
		
	}
*/
}
