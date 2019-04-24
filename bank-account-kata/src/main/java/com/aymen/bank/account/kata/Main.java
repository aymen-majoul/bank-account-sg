package com.aymen.bank.account.kata;

import java.math.BigInteger;

import com.aymen.bank.account.kata.entities.Account;
import com.aymen.bank.account.kata.entities.StatementHistory;
import com.aymen.bank.account.kata.services.AccountService;
import com.aymen.bank.account.kata.services.impl.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		Account account = new Account(BigInteger.ZERO, new StatementHistory());

		AccountService accountService = new AccountServiceImpl();

		accountService.deposit(account, BigInteger.valueOf(100));
		accountService.withdraw(account, BigInteger.valueOf(50));
		accountService.deposit(account, BigInteger.valueOf(2000));
		accountService.print(account, System.out);
	}

}