package com.aymen.bank.account.kata.services.impl;

import java.io.PrintStream;

import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.services.StatementService;

public class StatementServiceImpl implements StatementService {

	@Override
	public void print(Statement statement, PrintStream printer) {
		StringBuilder builder = new StringBuilder();

		builder.append(statement.getOperation().getOperationType());
		builder.append(",  ");
		builder.append(statement.getOperation().getDate());
		builder.append(",  ");
		builder.append(statement.getOperation().getAmount());
		builder.append(",  ");
		builder.append(statement.getCurrentBalance());

		printer.println(builder.toString());
	}

}