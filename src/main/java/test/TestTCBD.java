package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class TestTCBD {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getDataSourceConnection();
			String xSql = "create table userMain(userId int primary key auto_increment,username varchar(20),password varchar(30));";
			ps = conn.prepareStatement(xSql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDataSource(conn, ps, rs);
			System.out.println("close done");
		}
	}
}
