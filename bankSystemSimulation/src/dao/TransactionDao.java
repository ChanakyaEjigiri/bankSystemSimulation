package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Transaction;

public interface TransactionDao {
	
	boolean createTransaction(Transaction transaction) throws SQLException;
	//boolean insertTransactionRecord(Transaction transaction) throws SQLException;
	List<Transaction> getTransactions(int accountNum) throws SQLException;
	List<Transaction> sortTransactionsByDate() throws SQLException;
	List<Transaction> sortTransactionByAmount() throws SQLException;
	List<Transaction> getCreditTransactions() throws SQLException;
	List<Transaction> getdebitTransactions() throws SQLException;
	
}
