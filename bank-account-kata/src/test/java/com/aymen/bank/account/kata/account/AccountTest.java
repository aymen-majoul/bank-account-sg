package com.aymen.bank.account.kata.account;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import com.aymen.bank.account.kata.entities.Account;
import com.aymen.bank.account.kata.entities.StatementHistory;

public class AccountTest {

	Account account;

	@Before
	public void setUp() {
		account = new Account(BigInteger.valueOf(500), new StatementHistory());
	}

	@Test
	public void testDeposit() {
	}

	@Test
	public void testWithdraw() {
	}

	@Test
	public void testWrongAmountDeposit() {
	}

	@Test
	public void testWrongAmountWithdraw() {
	}
	
	@Test
	public void testUnsufficientFundsWithdraw() {
	}

	@Test
	public void testDepositHistory() {
	}

	@Test
	public void testWithdrawHistory() {
	}

}