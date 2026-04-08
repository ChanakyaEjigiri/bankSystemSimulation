package dao;

import java.sql.SQLException;

import entity.Account;

public interface AccountDao {
	
	boolean createAccount(Account account) throws SQLException;
	boolean updateBalance(int accountId, double amount) throws SQLException;
	Double getBalance(int accountId) throws SQLException;
	Account getAccountByUserId(int userId) throws SQLException;
	Account getAccount(int accountNum) throws SQLException;
	boolean deleteAccount(int accountNum) throws SQLException;
}
