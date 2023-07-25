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

import com.mvc.common.DBCon;

public class MovieInfoRepository {

	public List<Map<String, String>> selectMovieInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Map<String, String>> movieInfoList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> movieInfo = new HashMap<>();
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miTitle", rs.getString("MI_TITLE"));
				movieInfo.put("miDesc", rs.getString("MI_DESC"));
				movieInfo.put("miGenre", rs.getString("MI_GENRE"));
				movieInfo.put("miCredat", rs.getString("MI_CREDAT"));
				movieInfo.put("miCnt", rs.getString("MI_CNT"));
				movieInfoList.add(movieInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieInfoList;
	}

	public Map<String, String> selectMovieInfo(String miNum) {

		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Map<String, String>> movieInfoList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT*FROM MOVIE_INFO WHERE 1=1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> movieInfo = new HashMap<>();
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miTitle", rs.getString("MI_TITLE"));
				movieInfo.put("miDesc", rs.getString("MI_DESC"));
				movieInfo.put("miGenre", rs.getString("MI_GENRE"));
				movieInfo.put("miCredat", rs.getString("MI_CREDAT"));
				movieInfo.put("miCnt", rs.getString("MI_CNT"));
				movieInfoList.add(movieInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertMovieInfo(Map<String, String> movieInfo) {
		String sql = "INSERT INTO MOVIE_INFO(MI_TITLE, MI_DESC, MI_GENRE, MI_CREDAT, MI_CNT)";
		sql += " VALUE(?,?,?)";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieInfo.get("miNum"));
			ps.setString(2, movieInfo.get("miTitle"));
			ps.setString(3, movieInfo.get("miDesc"));
			ps.setString(4, movieInfo.get("miGenre"));
			ps.setString(5, movieInfo.get("miCredat"));
			ps.setString(6, movieInfo.get("miCnt"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateMovieInfo(Map<String, String> movieInfo) {
		String sql = "UPDATE MOVIE_INFO";
		sql += "SET_MI_TITLE";
		sql += "MI_DESC=?";
		sql += "MI_GENRE=?";
		sql += "MI_CREDAT=?";
		sql += "MI_CNT=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieInfo.get("miNum"));
			ps.setString(2, movieInfo.get("miTitle"));
			ps.setString(3, movieInfo.get("miDesc"));
			ps.setString(4, movieInfo.get("miGenre"));
			ps.setString(5, movieInfo.get("miCredat"));
			ps.setString(6, movieInfo.get("miCnt"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteMovieInfo(String miNum) {
		String sql = "DELETE FROM MOVIE_INTO WHERE MI_NUM=?";
		
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, miNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
