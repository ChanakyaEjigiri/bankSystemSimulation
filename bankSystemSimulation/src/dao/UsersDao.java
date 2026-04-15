package dao;

import java.sql.SQLException;

import entity.User;

public interface UsersDao {
	boolean createUser(User user) throws SQLException;
	boolean updateUser(User user) throws SQLException;
	User getUserByUserId(int userId) throws SQLException;
	User getUserByUserName(String username) throws SQLException;
	User getUserByMobile(String mobile) throws SQLException;
	boolean deleteUser(String userName) throws SQLException;
	
}
