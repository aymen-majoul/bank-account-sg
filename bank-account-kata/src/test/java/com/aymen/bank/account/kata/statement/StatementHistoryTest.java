package com.aymen.bank.account.kata.statement;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.aymen.bank.account.kata.entities.Operation;
import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.entities.StatementHistory;
import com.aymen.bank.account.kata.entities.enums.OperationType;
import com.aymen.bank.account.kata.services.StatementHistoryService;
import com.aymen.bank.account.kata.services.impl.StatementHistoryServiceImpl;

public class StatementHistoryTest {

	StatementHistory statementHistory;

	StatementHistoryService statementHistoryService;

	@Before
	public void setUp() {
		statementHistory = new StatementHistory();
		statementHistoryService = new StatementHistoryServiceImpl();
	}

	@Test
	public void testAddStatementLine() {
		Operation operation = new Operation(OperationType.WITHDRAW, new Date(), BigInteger.valueOf(20));
		Statement statement = new Statement(operation, BigInteger.valueOf(100));

		statementHistoryService.add(statementHistory, statement);

		assertTrue(statementHistory.getAccountStatements().contains(statement));
	}

}