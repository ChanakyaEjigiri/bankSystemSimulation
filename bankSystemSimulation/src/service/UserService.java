package service;

import java.sql.SQLException;

import daoImplementation.UsersDaoImpl;
import entity.User;

public class UserService {
	
	static UsersDaoImpl dao=new UsersDaoImpl();
	
	public boolean RegisterService(User user) {
		try {
			boolean isRegistered=dao.createUser(user);
			return isRegistered;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public User LoginService(String userName, String password) {
		User user=new User();
		try {
			user=dao.getUserByUserName(userName);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void LogoutService() {
		
	}
}
