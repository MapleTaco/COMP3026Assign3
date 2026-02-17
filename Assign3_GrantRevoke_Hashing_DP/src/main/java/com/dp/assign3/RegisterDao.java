package com.dp.assign3;

/*
Student Name: Daniel Perusse
Student ID: 200551990
Student Email: 200551990@student.georgianc.on.ca
COMP3026 - Application Security Programming
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {

	//method to get user data from database
	public String[] selectUser(RegisterPage registerPage) throws ClassNotFoundException {

		String SELECT_USERS_SQL = "SELECT * FROM Assign3Users WHERE UserName=?";

		String[] userInfo = new String[4];

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasecdb",
				"comp3026_w2026_DP", "QWERTY56")) {
			PreparedStatement ps = connection.prepareStatement(SELECT_USERS_SQL);
			ps.setString(1, registerPage.getUser_name());

			ResultSet rst = ps.executeQuery();
			rst.next();

			userInfo[0] = rst.getString("UserName");
			userInfo[1] = rst.getString("Password");
			userInfo[2] = rst.getString("PhoneNumber");
			userInfo[3] = rst.getString("Email");

		} catch (SQLException e) {
			System.out.println(e);
		}

		return userInfo;
	}

	public int registerPage(RegisterPage registerPage) throws ClassNotFoundException {

		// basically same thing from last assignment, nothing new
		String INSERT_USERS_SQL = "INSERT INTO Assign3Users VALUES (?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasecdb",
				"comp3026_w2026_DP", "QWERTY56")) {

			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
			ps.setString(1, registerPage.getUser_name());
			ps.setString(2, registerPage.getPassword());
			ps.setString(3, registerPage.getPhone_number());
			ps.setString(4, registerPage.getEmail());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return 0;
	}

}
