package com.aymen.bank.account.kata.services;

import java.io.PrintStream;
import java.math.BigInteger;

import com.aymen.bank.account.kata.entities.Account;
import com.aymen.bank.account.kata.exception.UnsufficientFundsException;
import com.aymen.bank.account.kata.exception.WrongAmountException;

public interface AccountService {

	void deposit(Account account, BigInteger amount) throws WrongAmountException;

	void withdraw(Account account, BigInteger amount) throws WrongAmountException, UnsufficientFundsException;

	void print(Account account, PrintStream printStream);
}