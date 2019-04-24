package com.aymen.bank.account.kata.services;

import java.io.PrintStream;

import com.aymen.bank.account.kata.entities.Statement;

public interface StatementService {

	void print(Statement statement, PrintStream printer);

}