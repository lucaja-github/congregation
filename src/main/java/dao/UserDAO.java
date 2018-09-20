package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import entity.User;
import util.DatabaseUtil;

public class UserDAO {
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getDataSourceConnection();
			String sql = "SELECT * FROM userinfo_common";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String phonenumber =rs.getString(1);
				String password = rs.getString(2);
				User user = new User();
				user.setPhonenumber(phonenumber);
				user.setPassword(password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DatabaseUtil.closeDataSource(conn, ps, rs);
		}
		
		return users;
	}
	
	public void save(String user,String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseUtil.getDataSourceConnection();
			String sql = "INSERT INTO userinfo_common "
					+ "VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user);
			ps.setString(2, pass);
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DatabaseUtil.closeDataSource(conn, ps, null);
		}
		
	}
	
	/*public void save(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseUtil.getDataSourceConnection();
			String sql = "INSERT INTO t_user "
					+ "VALUES(null,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPhonenumber());
			ps.setString(3, user.getPassword());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DatabaseUtil.closeDataSource(conn, ps, null);
		}
		
	}*/
}
