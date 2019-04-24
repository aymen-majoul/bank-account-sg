package com.aymen.bank.account.kata.account;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.aymen.bank.account.kata.entities.Account;
import com.aymen.bank.account.kata.entities.Operation;
import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.entities.StatementHistory;
import com.aymen.bank.account.kata.entities.enums.OperationType;
import com.aymen.bank.account.kata.exception.UnsufficientFundsException;
import com.aymen.bank.account.kata.exception.WrongAmountException;
import com.aymen.bank.account.kata.services.AccountService;
import com.aymen.bank.account.kata.services.impl.AccountServiceImpl;

public class AccountTest {

	Account account;

	AccountService accountService;

	@Before
	public void setUp() {
		account = new Account(BigInteger.valueOf(500), new StatementHistory());
		accountService = new AccountServiceImpl();
	}

	@Test
	public void testDeposit() {
		BigInteger oldBalance = account.getBalance();
		accountService.deposit(account, BigInteger.valueOf(100));
		assertTrue(account.getBalance().subtract(oldBalance).equals(BigInteger.valueOf(100)));
	}

	@Test
	public void testWithdraw() {
		BigInteger oldBalance = account.getBalance();
		accountService.withdraw(account, BigInteger.valueOf(50));

		assertTrue(oldBalance.subtract(account.getBalance()).equals(BigInteger.valueOf(50)));
	}

	@Test(expected = WrongAmountException.class)
	public void testWrongAmountDeposit() {
		accountService.deposit(account, BigInteger.valueOf(-200));
	}

	@Test(expected = WrongAmountException.class)
	public void testWrongAmountWithdraw() {
		accountService.withdraw(account, BigInteger.valueOf(-200));
	}

	@Test(expected = UnsufficientFundsException.class)
	public void testUnsufficientFundsWithdraw() {
		accountService.withdraw(account, BigInteger.valueOf(1000));
	}

	@Test
	public void testDepositHistory() {
		accountService.deposit(account, BigInteger.valueOf(500));

		Operation operation = new Operation(OperationType.DEPOSIT, new Date(), BigInteger.valueOf(500));
		Statement expectedStatement = new Statement(operation, BigInteger.valueOf(1000));

		assertTrue(account.getStatementHistory().getAccountStatements().contains(expectedStatement));
	}

	@Test
	public void testWithdrawHistory() {
		accountService.withdraw(account, BigInteger.valueOf(500));

		Operation operation = new Operation(OperationType.WITHDRAW, new Date(), BigInteger.valueOf(500));
		Statement expectedStatement = new Statement(operation, BigInteger.ZERO);

		assertTrue(account.getStatementHistory().getAccountStatements().contains(expectedStatement));
	}

}