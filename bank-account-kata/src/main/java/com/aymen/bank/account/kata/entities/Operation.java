package com.aymen.bank.account.kata.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

import com.aymen.bank.account.kata.entities.enums.OperationType;

public class Operation {

	private final OperationType operationType;
	private final Date date;
	private final BigInteger amount;

	public Operation(OperationType operationType, Date date, BigInteger amount) {
		if (operationType == null) {
			throw new IllegalArgumentException("Operation type can't be null");
		}
		if (date == null) {
			throw new IllegalArgumentException("Date of the operation can't be null");
		}
		if (amount == null) {
			throw new IllegalArgumentException("Amount can't be null");
		}

		this.operationType = operationType;
		this.date = date;
		this.amount = amount;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public Date getDate() {
		return date;
	}

	public BigInteger getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, date, operationType);
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
		Operation other = (Operation) obj;
		if (!amount.equals(other.amount)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (operationType != other.operationType) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Operation [operationType=" + operationType + ", date=" + date + ", amount=" + amount + "]";
	}
}