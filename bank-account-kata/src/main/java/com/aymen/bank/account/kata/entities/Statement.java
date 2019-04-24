package com.aymen.bank.account.kata.entities;

import java.math.BigInteger;
import java.util.Objects;

public class Statement {

	private final Operation operation;
	private final BigInteger currentBalance;

	public Statement(Operation operation, BigInteger currentBalance) {
		if (operation == null) {
			throw new IllegalArgumentException("Operation can't be null");
		}
		if (currentBalance == null) {
			throw new IllegalArgumentException("Current balance can't be null");
		}

		this.operation = operation;
		this.currentBalance = currentBalance;
	}

	public Operation getOperation() {
		return operation;
	}

	public BigInteger getCurrentBalance() {
		return currentBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(operation, currentBalance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Statement other = (Statement) obj;
		if (!currentBalance.equals(other.currentBalance)) {
			return false;
		}
		if (operation == null) {
			if (other.operation != null) {
				return false;
			}
		} else if (!operation.equals(other.operation)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Statement [operation=" + operation + ", currentBalance=" + currentBalance + "]";
	}

}