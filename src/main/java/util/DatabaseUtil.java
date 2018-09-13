package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseUtil {
	/**
	 * 数据库连接池
	 */
	private static BasicDataSource dataSource;
	static {
		Properties property = new Properties();
		InputStream in = DatabaseUtil.class.getClassLoader().getResourceAsStream("congregation.properties");
		try {
			property.load(in);
			String driver = property.getProperty("driver");
			String url = property.getProperty("url");
			String username = property.getProperty("username");
			String password = property.getProperty("password");
			int initialSize = Integer.parseInt(property.getProperty("initialSize"));
			int maxActive = Integer.parseInt(property.getProperty("maxActive"));
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(initialSize);
			dataSource.setMaxActive(maxActive);
			System.out.println("OK");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getDataSourceConnection() throws SQLException {
		return dataSource.getConnection();
	}
	public static void closeDataSource(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps!=null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con!=null) {
				con.setAutoCommit(true);
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
