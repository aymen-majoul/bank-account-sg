package com.aymen.bank.account.kata.services.impl;

import java.io.PrintStream;

import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.entities.StatementHistory;
import com.aymen.bank.account.kata.services.StatementHistoryService;
import com.aymen.bank.account.kata.services.StatementService;

public class StatementHistoryServiceImpl implements StatementHistoryService {

	StatementService statementService = new StatementServiceImpl();

	@Override
	public void add(StatementHistory statementHistory, Statement item) {
		if (item != null) {
			statementHistory.getAccountStatements().add(item);
		}
	}

	@Override
	public void printHistory(StatementHistory statementHistory, PrintStream printStream) {
		statementHistory.getAccountStatements().forEach(s -> statementService.print(s, printStream));
	}

}