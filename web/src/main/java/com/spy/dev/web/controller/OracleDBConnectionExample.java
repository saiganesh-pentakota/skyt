package com.spy.dev.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBConnectionExample {

	public static void main(String[] args) {
		Connection connection = null;

		try {
			// Step 1: Load the Oracle JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step 2: Provide the connection details
			String username = "SPY";
			String password = "SPY123";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			// Step 3: Establish a Connection
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				System.out.println("Connected to Oracle database!");

				// Step 5: Execute Queries or Updates
				Statement statement = connection.createStatement();

			//	createUserTable(statement);

				insertUser(statement);

				getUser(statement);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC driver not found.");
		} catch (SQLException e) {
			System.out.println("Connection failed. Check your credentials or URL.");
		} finally {
			// Step 6: Close the connection (if it was opened)
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertUser(Statement statement) throws SQLException {
		String insertQuery = "INSERT INTO SPYUSERS (username, email, password) VALUES ('saiganesh', 'mca.saiganesh@gmail.com', '4231')";
		statement.executeUpdate(insertQuery);
	}

	@SuppressWarnings("unused")
	private static void createUserTable(Statement statement) {
		StringBuilder sql;

//		try {
//			sql = new StringBuilder("DROP TABLE SPYUSERS");
//			statement.executeUpdate(sql.toString());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			sql = new StringBuilder("CREATE TABLE SPYUSERS (");
			sql.append("id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,");
			sql.append("username VARCHAR2(50) NOT NULL UNIQUE,");
			sql.append("email VARCHAR2(100) NOT NULL UNIQUE,");
			sql.append("password VARCHAR2(100) NOT NULL,");
			sql.append("created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,");
			sql.append("last_login TIMESTAMP)");
			statement.execute(sql.toString());
			System.out.println("SPYUSERS Table created");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SPYUSERS Table already exists");
		}

	}

	private static void getUser(Statement statement) throws SQLException {
		String sqlQuery = "SELECT * FROM SPYUSERS";
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		while (resultSet.next()) {
			int userId = resultSet.getInt("id");
			String username1 = resultSet.getString("username");
			String email = resultSet.getString("email");
			System.out.println("User ID: " + userId + ", Username: " + username1 + ", Email: " + email);
		}
	}
}
