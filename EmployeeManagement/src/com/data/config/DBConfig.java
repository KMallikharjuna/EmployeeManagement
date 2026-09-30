package com.data.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	private Connection con;
	public DBConfig(String url, String user, String pwd, String driverClass) {
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			System.out.println("Unable to create connection");
		}
	}
	public Connection getConnection() {
		return con;
	}
}
