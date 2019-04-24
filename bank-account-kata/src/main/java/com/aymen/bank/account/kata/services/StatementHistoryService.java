package com.aymen.bank.account.kata.services;

import java.io.PrintStream;

import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.entities.StatementHistory;

public interface StatementHistoryService {
	
	void add(StatementHistory statementHistory, Statement item);
	
	void printHistory(StatementHistory statementHistory, PrintStream printStream);

}