package daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsersDao;
import entity.User;
import utils.DBConnectionUtil;

public class UsersDaoImpl implements UsersDao{

	@Override
	public boolean createUser(User user) throws SQLException {
		
		Connection con=DBConnectionUtil.getConnection();
		String sql="INSERT INTO `users` (`full_name`,`username`,`password`,`mobile_number`,`address`) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		String userName=user.getUserName();
		String fullName=user.getFullName();
		String password=user.getPassword();
		String mobile=user.getMobileNumber();
		String adress=user.getAdress();
		
		ps.setString(1, fullName);
		ps.setString(2, userName);
		ps.setString(3, password);
		ps.setString(4, mobile);
		ps.setString(5, adress);
		
		int row=ps.executeUpdate();

		ps.close();
		con.close();
		
		return row>0;
	}

	@Override
	public boolean updateUser(String userName, String password) throws SQLException {
		String sql="UPDATE `users` SET `password` = ? WHERE (`user_name` = ?)";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, password);
		ps.setString(2, userName);
		int rowsupdated=ps.executeUpdate();		
		return rowsupdated>0;
		
	}

	@Override
	public User getUserByUserId(int userId) throws SQLException {
		String sql="select * from `users` where `username`=?";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs=ps.executeQuery();
		User user=new User();
		if(rs.next()) {
			user.setUserId(rs.getInt(1));
			user.setFullName(rs.getString(2));
			user.setUserName(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setMobileNumber(rs.getString(5));
			user.setAdress(rs.getString(6));
		}		
		
		
		return user;
		
	}

	@Override
	public User getUserByUserName(String username) throws SQLException {
		String sql="select * from `users` where `username`=?";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		User user=new User();
		if(rs.next()) {
			user.setUserId(rs.getInt(1));
			user.setFullName(rs.getString(2));
			user.setUserName(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setMobileNumber(rs.getString(5));
			user.setAdress(rs.getString(6));
		}		
				
		return user;
	}

	@Override
	public User getUserByMobile(String mobile) throws SQLException {
		String sql="select * from `users` where `username`=?";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mobile);
		ResultSet rs=ps.executeQuery();
		User user=new User();
		if(rs.next()) {
			user.setUserId(rs.getInt(1));
			user.setFullName(rs.getString(2));
			user.setUserName(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setMobileNumber(rs.getString(5));
			user.setAdress(rs.getString(6));
		}		
				
		return user;
	}

	@Override
	public boolean deleteUser(String userName) throws SQLException {
		String sql="delete from `users` where `username`=?";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userName);
		
		int rowsUpdated=ps.executeUpdate();
		return rowsUpdated>0;
		
	}



}
