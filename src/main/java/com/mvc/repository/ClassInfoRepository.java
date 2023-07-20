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

public class ClassInfoRepository {

	public List<Map<String,String>> selectClassInfoList() {
		
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Map<String, String>> classInfoList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url,user,pwd);
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Map<String, String>> classInfo = new ArrayList<>();
		Connection con;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "SELECT*FROM CLASS_INFO WHERE 1=1";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return classInfoList;	
		
	}
	
	public Map<String, String> selectClassInfo(String ciNum){
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
			String sql = "SELECT *FROM CLASS_INFO  WHERE CI_NUM = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ciNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				return classInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
		}
		
	
	
	public static void main(String[] args) {
		ClassInfoRepository ciRepo = new ClassInfoRepository();
		List<Map<String, String>> classInfoList = ciRepo.selectClassInfoList();
//		for Map<String, String>> classInfo : classInfoList)
//		ciRepo.selectClassInfoList();
	}
}
