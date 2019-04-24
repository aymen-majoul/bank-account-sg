package com.aymen.bank.account.kata.entities;

import java.math.BigInteger;

public class Account {

	private BigInteger balance;
	private StatementHistory history;

	public Account(BigInteger balance, StatementHistory history) {
		if (balance == null || balance.signum() < 0) {
			throw new IllegalArgumentException("Please enter a positive balance");
		}

		this.balance = balance;

		if (history != null) {
			this.history = history;
		} else {
			this.history = new StatementHistory();
		}
	}

	public BigInteger getBalance() {
		return balance;
	}

	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}

	public void setHistory(StatementHistory history) {
		this.history = history;
	}

	public StatementHistory getStatementHistory() {
		return history;
	}
}