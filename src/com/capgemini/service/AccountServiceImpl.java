package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	
	AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientInitialAmountException
	{
		int a,b,c;
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		account.setAmount(amount);
		 
		if(accountRepository.save(account))
		{
			return account;
		}
	     
		return null;
		
	}


	@Override
	public Boolean deposit(int accountNumber, int amount) throws InvalidAccountNumberException {
		
		if (accountNumber<=0) {
			throw new InvalidAccountNumberException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		account.setAmount(amount);
		 
		if(accountRepository.update(account))
		{
			return true;
		}
		return false;
	}


	@Override
	public int withdraw(int accountNumber, int amount) throws InsufficientBalanceException {
		
		if (amount<100) {
			throw new InsufficientBalanceException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		account.setAmount(500-amount);
		 
		if(amount<500)
		{
			return 1;
		}
		
		return 0;
	}

}
