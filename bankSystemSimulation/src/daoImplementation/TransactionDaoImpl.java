package daoImplementation;

import java.util.List;

import dao.TransactionDao;
import entity.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public boolean createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertTransactionRecord(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> sortTransactionsByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> sortTransactionByAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getCreditTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getdebitTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
