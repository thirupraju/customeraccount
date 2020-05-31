package com.ms.customer.account.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter @Setter
@Table(name="CustomerAccount")
public class CustomerAccount {
	@Id
	private String customerId;
	
//	@PositiveOrZero(message = "All numbers is not valid")
	private String accountName;
	private String accountType;
/*
	public CustomerAccount(String customerId, String accountName, String accountType) {
		this.customerId = customerId;
		this.accountName = accountName;
		this.accountType = accountType;
	}
*/

/*
//All get	
	public String getCustomerId() {
		return customerId;
	}
	public String getAccountName() {
		return accountName;
	}
	public String getAccountType() {
		return accountType;
	}


//All Set
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
*/
	
}
