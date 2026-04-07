package dao;

import java.util.List;

import entity.Transaction;

public interface TransactionDao {
	
	boolean createTransaction(Transaction transaction);
	boolean insertTransactionRecord(Transaction transaction);
	List<Transaction> getTransactions();
	List<Transaction> sortTransactionsByDate();
	List<Transaction> sortTransactionByAmount();
	List<Transaction> getCreditTransactions();
	List<Transaction> getdebitTransactions();
	
}
