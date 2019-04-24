package com.aymen.bank.account.kata.services.impl;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Date;

import com.aymen.bank.account.kata.entities.Account;
import com.aymen.bank.account.kata.entities.Operation;
import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.entities.enums.OperationType;
import com.aymen.bank.account.kata.exception.UnsufficientFundsException;
import com.aymen.bank.account.kata.exception.WrongAmountException;
import com.aymen.bank.account.kata.services.AccountService;
import com.aymen.bank.account.kata.services.StatementHistoryService;

public class AccountServiceImpl implements AccountService {

	StatementHistoryService statementHistoryService = new StatementHistoryServiceImpl();

	@Override
	public void deposit(Account account, BigInteger amount) throws WrongAmountException {
		if (amount == null) {
			throw new IllegalArgumentException("Amount can't be null");
		}
		if (amount.signum() < 0) {
			throw new WrongAmountException("Please enter a positive amount");
		}

		executeOperation(account, OperationType.DEPOSIT, amount);
	}

	@Override
	public void withdraw(Account account, BigInteger amount) throws WrongAmountException, UnsufficientFundsException {
		if (amount == null) {
			throw new IllegalArgumentException("Amount can't be null");
		}
		if (amount.signum() < 0) {
			throw new WrongAmountException("Please enter a positive amount");
		}
		if (amount.compareTo(account.getBalance()) > 0) {
			throw new UnsufficientFundsException(
					"You don't have enough money in your account to withdraw this amount!");
		}

		executeOperation(account, OperationType.WITHDRAW, amount.negate());
	}

	@Override
	public void print(Account account, PrintStream printStream) {
		statementHistoryService.printHistory(account.getStatementHistory(), printStream);
	}

	private void executeOperation(Account account, OperationType operationType, BigInteger amount) {
		account.setBalance(account.getBalance().add(amount));
		addStatementToHistory(account, operationType, amount.abs());
	}

	private void addStatementToHistory(Account account, OperationType operationType, BigInteger amount) {
		Operation operation = new Operation(operationType, new Date(), amount);
		Statement statement = new Statement(operation, account.getBalance());
		statementHistoryService.add(account.getStatementHistory(), statement);
	}

}