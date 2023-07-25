package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

	private static final String DRIEVER_NAME = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3307/kd";
	private static final String USER = "root";
	private static final String PWD = "kd1824java";
	static {
		try {
			Class.forName(DRIEVER_NAME);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
	try {
		return DriverManager.getConnection(URL, USER, PWD);
	}catch (SQLException e) {
		
	}
	return null;
	}
	public static void main(String[] args) {
		
			System.out.println("난 안녕 뒤에 나옴");
	}
}
