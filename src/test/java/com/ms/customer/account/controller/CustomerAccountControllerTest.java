package com.ms.customer.account.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ms.customer.account.service.CustomerAccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerAccountController.class)
public class CustomerAccountControllerTest {

//	@Autowired
	
	@MockBean
	private CustomerAccountService service;

	@Test
	public void testMethod() {
		//Use specific data
		
		//Expect the response
	}
		
}
