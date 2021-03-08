package com.student.webservices.h2connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionFactory {

	public static Connection getConnection()  {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:./h2db/studentdb", "sa", "");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
