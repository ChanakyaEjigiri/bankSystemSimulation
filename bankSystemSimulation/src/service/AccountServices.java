package service;

import java.sql.SQLException;

import daoImplementation.AccountsDaoImpl;
import entity.User;

public class AccountServices {
	
	//createAccount
	//deposit money
	//withdraw money
	//transfer money
	//balance inquiry
	AccountsDaoImpl acc=new AccountsDaoImpl();
	public void createAccount(User user) {
		
	}
	public boolean deposit(double amount, int accountNum) {
		try {
			double curBalance=acc.getBalance(accountNum);
			double updatedBalance=curBalance+amount;
			boolean isUpdated=acc.updateBalance(accountNum, updatedBalance);
			return isUpdated;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public void withdraw(double amount) {
		
	}
	public void transfer(double money, int targetAccountid) {
		
	}
	public void getBalance() {
		
	}
	
}
