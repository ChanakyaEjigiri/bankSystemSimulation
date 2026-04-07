package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	protected static final String JDBC_URL="jdbc:mysql://localhost:3306/practice";
	protected static final String JDBC_USER="root";
	protected static final String JDBC_PASSWORD="0000";
	protected static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
