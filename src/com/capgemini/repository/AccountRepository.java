package com.capgemini.repository;

import com.capgemini.model.Account;

public interface AccountRepository {
	
	boolean save(Account account);
	
	boolean update(Account account);
	
	Account searchAccount(int accountNumber);

}
