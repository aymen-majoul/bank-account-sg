package com.aymen.bank.account.kata.statement;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aymen.bank.account.kata.entities.Operation;
import com.aymen.bank.account.kata.entities.Statement;
import com.aymen.bank.account.kata.entities.enums.OperationType;
import com.aymen.bank.account.kata.services.StatementService;
import com.aymen.bank.account.kata.services.impl.StatementServiceImpl;

public class StatementTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();

	StatementService statementService;

	@Before
	public void setUp() {
		statementService = new StatementServiceImpl();
		setUpStreams();
	}

	private void setUpStreams() {
		System.setOut(new PrintStream(output));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionOperationNull() {
		new Statement(null, BigInteger.valueOf(1000));
	}

	@Test
	public void testPrintStatement() {
		Date date = new Date();
		Operation operation = new Operation(OperationType.DEPOSIT, date, BigInteger.valueOf(50));
		Statement statement = new Statement(operation, BigInteger.valueOf(200));
		statementService.print(statement, System.out);
		assertEquals("DEPOSIT,  " + date + ",  50,  200", output.toString().trim());
	}

}