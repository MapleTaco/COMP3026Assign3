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
import java.sql.SQLException;

public class RegisterDao {
	
	public String selectUser(RegisterPage registerPage) throws ClassNotFoundException {
		return "test";
	}

	public int registerPage(RegisterPage registerPage) throws ClassNotFoundException {
		
		String INSERT_USERS_SQL = "INSERT INTO Assign3Users VALUES (?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasecdb", "comp3026_w2026_DP", "QWERTY56")) {
			
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
