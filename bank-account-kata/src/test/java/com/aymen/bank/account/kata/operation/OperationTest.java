package com.aymen.bank.account.kata.operation;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Test;

import com.aymen.bank.account.kata.entities.Operation;
import com.aymen.bank.account.kata.entities.enums.OperationType;

public class OperationTest {

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionOperationTypeNull() {
		new Operation(null, new Date(), BigInteger.valueOf(100));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionDateNull() {
		new Operation(OperationType.WITHDRAW, null, BigInteger.valueOf(100));
	}

}
