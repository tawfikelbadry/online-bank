package com.tawfik.userfront.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PrimaryAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int accountNumber;
	private BigDecimal accountBalance;
	
	
	@OneToMany(mappedBy="primaryAccount",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<PrimaryTransaction> transactionsList;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public BigDecimal getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}


	public List<PrimaryTransaction> getTransactionsList() {
		return transactionsList;
	}


	public void setTransactionsList(List<PrimaryTransaction> transactionsList) {
		this.transactionsList = transactionsList;
	}
	
	
}
