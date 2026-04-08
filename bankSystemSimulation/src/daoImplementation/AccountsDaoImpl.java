package daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AccountDao;
import entity.Account;
import entity.AccountType;
import utils.DBConnectionUtil;

public class AccountsDaoImpl implements AccountDao {

	@Override
	public boolean createAccount(Account account) throws SQLException {
		String sql="INSERT INTO `accounts` (`account_id`,`user_id`,`account_type`,`balance`) VALUES (?,?,?,?)";
		
		Connection con=DBConnectionUtil.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, account.getAccountId());
		ps.setInt(2, account.getUserId());
		ps.setString(3,account.getAccountType().name());
		ps.setDouble(4, account.getBalance());
		
		int row=ps.executeUpdate();

		ps.close();
		con.close();
		
		return row>0;
	}

	@Override
	public boolean updateBalance(int accountId,double amount) throws SQLException {
		String sql="UPDATE `accounts` SET `balance` = ? WHERE `account_id`=?";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(2,accountId);
		ps.setDouble(1, amount);
		int rowsupdated=ps.executeUpdate();		
		return rowsupdated>0;
	}

	@Override
	public Double getBalance(int accountId) throws SQLException {
		String sql="SELECT `balance` FROM `accounts` WHERE `account_id`=?";
		
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1,accountId);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			double balance=rs.getDouble("balance");
			return balance;
		}
		return null;
	}

	@Override
	public Account getAccountByUserId(int userId) throws SQLException {
		String sql="SELECT * FROM `accounts` WHERE` `userId`=?";
		
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1,userId);
		
		ResultSet rs=ps.executeQuery(sql);
		if(rs.next()) {
			Account account=new Account();//account_id`,`user_id`,`account_type`,`balance
			account.setAccountId(rs.getInt(1));
			account.setUserId(rs.getInt(2));
			account.setAccountType(AccountType.valueOf(rs.getString(3)));
			
			return account;
		}
		return null;
	}

	@Override
	public Account getAccount(int accountNum) throws SQLException {
String sql="SELECT * FROM `accounts` WHERE` `accountNum`=?";
		
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1,accountNum);
		
		ResultSet rs=ps.executeQuery(sql);
		if(rs.next()) {
			Account account=new Account();
			account.setAccountId(rs.getInt(1));
			account.setUserId(rs.getInt(2));
			account.setAccountType(AccountType.valueOf(rs.getString(3)));
			return account;
		}
		return null;
	}

	@Override
	public boolean deleteAccount(int accountNum) throws SQLException {
		
		String sql="DELETE FROM `accounts` WHERE `account_id`=?";
		Connection con=DBConnectionUtil.getConnection();
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setInt(1, accountNum);
		int rowsUpdated=ps.executeUpdate();
				
		return rowsUpdated>0;
		
	}

}
