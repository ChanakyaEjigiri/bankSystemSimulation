package dao;

import entity.Account;

public interface AccountDao {
	
	boolean createAccount(Account account);
	boolean updateBalance(double amount);
	Double getBalance(int accountId);
	Account getAccountByUserId(int userId);
	Account getAccount(int accountNum);
	boolean deleteAccount();
}
