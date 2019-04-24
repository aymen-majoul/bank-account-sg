package com.aymen.bank.account.kata.exception;

public class WrongAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WrongAmountException() {
		super();
	}

	public WrongAmountException(String string) {
		super(string);
	}

}