package entity;


public class Account {
	private int accountId;
	private int userId;
	private String accountType;
	private Double balance;
	
	public Account() {
		
	}
	public Account(int accountId, int userId, String accountType, Double balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
