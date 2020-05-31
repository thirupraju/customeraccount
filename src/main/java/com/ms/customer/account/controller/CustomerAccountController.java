package com.ms.customer.account.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.customer.account.configuration.BasicConfiguration;
import com.ms.customer.account.entity.CustomerAccount;
//import com.ms.customer.account.exception.ResourceNotFoundException;
import com.ms.customer.account.service.CustomerAccountService;

@RestController
public class CustomerAccountController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerAccountService service;
	
	@Autowired
	private BasicConfiguration basicConfiguration;
	
/*
	@RequestMapping("/dynamic-Configuration")
	public Map dynamicConfiguration() {
		Map map = new HashMap();
		map.put("message", basicConfiguration.getMessage());
		map.put("number", basicConfiguration.getNumber());
		map.put("value", basicConfiguration.isValue());
		
		return map;
	}
*/	
	@PostMapping("addCustomerAccount")
	public ResponseEntity<CustomerAccount> addCustomerAccount(@RequestBody @Valid CustomerAccount customerAccount, BindingResult result) {
		String accountName = customerAccount.getAccountName();
		if (accountName.replaceAll("[0-9]","").length() == 0) {
			logger.info("Name contains all digits which is not acceptable");
			//return 	"Invalid Account Name - contains all numbers";
//	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerAccount);
			return new ResponseEntity<>(customerAccount, HttpStatus.BAD_REQUEST);
		}
		
	    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(accountName);
	 
	    if (!matcher.matches()) {
	       System.out.println("string '"+accountName + "' contains special character");
	       logger.info("Account Name contains Special Characters - is not acceptable");
	       //return 	"Invalid Account Name - contains special characters";
//	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerAccount);
	       return new ResponseEntity<>(customerAccount, HttpStatus.BAD_REQUEST);
	       //return customerAccount;
	     }

	    if (result.hasErrors()) {
	    	logger.info("Customer Account unable to Save - unknown issue");
	    	return new ResponseEntity<>(customerAccount, HttpStatus.BAD_REQUEST);
	    }
	    
	    CustomerAccount savedCustomerAccount;
    	savedCustomerAccount = service.saveCustomerAccount(customerAccount);
    	if (result.hasErrors()) {
    		System.out.println("customer account NOT saved " + result.toString());
    		return new ResponseEntity<>(savedCustomerAccount, HttpStatus.BAD_REQUEST);
    	} else {
	    	System.out.println("customer account saved successfully ");
    		return new ResponseEntity<>(savedCustomerAccount, HttpStatus.CREATED);
	    } 
//    	catch (ResourceNotFoundException e) {
//			new ResourceNotFoundException("Customer Account NOT saved");
//			return new ResponseEntity<>(customerAccount, HttpStatus.BAD_REQUEST);
//		}
//		logger.info("Customer Account saved successfully");
//		return new ResponseEntity<>(savedCustomerAccount, HttpStatus.CREATED);
		
/*		
	    try {
			 return ResponseEntity.created(new URI("/addCustomerAccount/" + customerAccount.getCustomerId())).body(customerAccount);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			logger.info("Customer Account NOT saved with unknow error - " + e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerAccount);
		}
*/
		//return "Successfully saved ||" + customerAccount.getCustomerId();
    	//return ResponseEntity.created(new URI("/addCustomerAccount/" + customerAccount.getCustomerId())).body(customerAccount);		
		//return customerAccount;
	}

	@PostMapping("addCustomerAccounts")
	public List<CustomerAccount> addCustomerAccounts(@RequestBody List<CustomerAccount> customerAccounts) {
		  logger.debug("This is a debug message");
	      logger.info("This is an info message");
	      logger.warn("This is a warn message");
	      logger.error("This is an error message");
//	      new SpringLoggingHelper().helpMethod();

		return service.saveCustomerAccounts(customerAccounts);
	}

	@GetMapping("customeraccount/{customerId}")
	public CustomerAccount findCustomerAccountByCustomerId(@PathVariable String customerId) {
		return service.getCustomerAccountById(customerId);
	}
	
	@GetMapping("customeraccounts")
	public List<CustomerAccount> findAllCustomerAcconuts() {
		return service.getCustomerAccounts();
	}
	
	@GetMapping("customerByAccountName/{accountName}")
	public CustomerAccount findCustomerAccountByAccountName(@PathVariable String accountName) {
		return service.getCustomerAccountByName(accountName);
	}
	
	@PutMapping("update")
	public CustomerAccount updateCustomerAccount(@RequestBody CustomerAccount customerAccount) {
		return service.updateCustomerAccount(customerAccount);
	}
	
	@DeleteMapping("delete/{customerId}")
	public String deleteCustomerAccount(@PathVariable String customerId) {
		return service.deleteCustomerAccount(customerId);
	}
	
	
}
