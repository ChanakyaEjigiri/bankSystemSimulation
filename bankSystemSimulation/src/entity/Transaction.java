package entity;

import java.time.LocalDateTime;

public class Transaction {
	private String transactionId;
	private String accountNum;
	private String accountType;
	private double amount;
	private String targetAccountid;
	private LocalDateTime date;
	
	public Transaction() {
		
	}
	
	public Transaction(String transactionId, String accountNum, String accountType, double amount,
			String targetAccountid) {
		super();
		this.transactionId = transactionId;
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.amount = amount;
		this.targetAccountid = targetAccountid;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTargetAccountid() {
		return targetAccountid;
	}

	public void setTargetAccountid(String targetAccountid) {
		this.targetAccountid = targetAccountid;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	
	
}
