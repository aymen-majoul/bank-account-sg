package com.aymen.bank.account.kata.entities.enums;

public enum OperationType {
	WITHDRAW("-"), DEPOSIT("+");

	private final String operationCode;

	private OperationType(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationCode() {
		return operationCode;
	}
}