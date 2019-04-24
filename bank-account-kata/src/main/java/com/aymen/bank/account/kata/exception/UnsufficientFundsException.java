package com.aymen.bank.account.kata.exception;

public class UnsufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsufficientFundsException() {
		super();
	}

	public UnsufficientFundsException(String string) {
		super(string);
	}

}