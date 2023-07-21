package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoRepository {

	
public List<Map<String,String>> selectUserInfoList() {
	
	String driverName = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3307/kd";
	String user = "root";
	String pwd = "kd1824java";
	try {
		Class.forName(driverName);		
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	List<Map<String,String>> userInfoList = new ArrayList<>();
	Connection conn;
	try {
		conn = DriverManager.getConnection(url,user,pwd);
		String sql = "SELECT *FROM USER_INFO WHERE 1=1";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		Map<String,String> userInfo = new HashMap<>();
		userInfo.put("uiNum", rs.getString("UI_NUM"));
		userInfo.put("uiId", rs.getString("UI_ID"));
		userInfo.put("uiPwd", rs.getString("UI_PWD"));
		userInfo.put("uiName", rs.getString("UI_NAME"));
		 userInfoList.add(userInfo);
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	List<Map<String, String>> userInfo = new ArrayList<>();
	Connection con;
	
	try {
		con = DriverManager.getConnection(url,user,pwd);
		String sql = "SELECT*FROM USER_INFO WHERE 1=1";
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return userInfoList;	
	
}

public Map<String, String> selectUserInfo(String uiNum){
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3307/kd";
	String user = "root";
	String pwd = "kd1824java";
	
	try {
		Class.forName(driver);
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
		Connection con = DriverManager.getConnection(url,user,pwd);
		String sql = "SELECT *FROM USER_INFO  WHERE UI_NUM = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Map<String, String> userInfo = new HashMap<>();
			userInfo.put("uiNum", rs.getString("UI_NUM"));
			userInfo.put("uiId", rs.getString("UI_ID"));
			userInfo.put("uiPwd", rs.getString("UI_PWD"));
			userInfo.put("uiName", rs.getString("UI_NAME"));
			return userInfo;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return null;
	}
	


public static void main(String[] args) {
	UserInfoRepository uiRepo = new UserInfoRepository();
	List<Map<String, String>> userInfoList = uiRepo.selectUserInfoList();
	for (Map<String, String> userInfo : userInfoList)
	uiRepo.selectUserInfoList();
}
}

