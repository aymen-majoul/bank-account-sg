package com.aymen.bank.account.kata.services;

import java.io.PrintStream;
import java.math.BigInteger;

import com.aymen.bank.account.kata.entities.Account;

public interface AccountService {

	void deposit(Account account, BigInteger amount);

	void withdraw(Account account, BigInteger amount);

	void print(Account account, PrintStream printStream);
}