package shoplap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public connectDB() {
		super();
	}

	public static Connection getConnect() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SHOPLAP;user=sa;password=123");
			System.out.println("Connect Successed!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connect Failed!" + e.getMessage());
		}
		return connection;
	}

	public static void main(String[] args) {
		System.out.println(getConnect());
	}
}